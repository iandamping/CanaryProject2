package com.junemon.daggerinyourface.data.db.game.paging

import androidx.paging.DataSource
import com.junemon.daggerinyourface.data.db.GameDatabase
import com.junemon.daggerinyourface.model.data.database.game.GamePagingDbEntity
import javax.inject.Inject

class GamePagingDaoInjector @Inject constructor(private val database: GameDatabase) : GamePagingDao {
    override suspend fun insertGame(vararg data: GamePagingDbEntity) {
        database.gamePagingDao().insertGame(*data)
    }

    override fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity> {
       return database.gamePagingDao().loadGame()
    }
}
