package com.junemon.daggerin.feature.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.adapter.BaseActivity
import com.junemon.daggerin.databinding.ActivityMainBinding
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.di.injector.inject
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.model.game.GameCallback
import com.junemon.daggerin.util.Constant.intentGamesDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_games.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(),
    MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        inject().getMainActivityComponent().inject(this).injectActivity(this)

    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        lifecycleScope.launchWhenStarted {
            presenter.getData()
        }
    }


    override fun observeData(data: List<GameDbEntity>) {
        if (::binding.isInitialized) {
            binding.apply {
                recyclerHelper.run {
                    rvMain.setUpVerticalListAdapter(items = data,
                        diffUtil = GameCallback.gamesDiffCallbacks,
                        layoutResId = R.layout.item_games,
                        bindHolder = {
                            tvText.text = it.gameName
                            loadImageHelper.run {
                                ivImages.loadWithGlide(it.gameImage)
                            }
                        }, itemClick = {
                            val intent by lazy {
                                Intent(
                                    this@MainActivity,
                                    GameDetailActivity::class.java
                                )
                            }
                            intent.putExtra(intentGamesDetailKey,gameId)
                            startActivity(intent)
                        })
                }

            }
        }

    }

    override fun observeFailed(throws: Throwable) {
        if (::binding.isInitialized) Snackbar.make(
            binding.mainRootLayout,
            throws.localizedMessage,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun setDialogShow(data: Boolean) {
        openDialog(data)
    }


}
