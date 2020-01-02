package com.junemon.daggerinyourface.cache.util.classes

import androidx.paging.DataSource
import com.junemon.daggerinyourface.cache.util.interfaces.GamePagingDaoHelper
import com.junemon.daggerinyourface.cache.game.paging.GamePagingDao
import com.junemon.daggerinyourface.cache.game.paging.GamePagingDbEntity
import javax.inject.Inject

class GamePagingDaoHelperImpl @Inject constructor(private val gamePagingDao: GamePagingDao) :
    GamePagingDaoHelper {
    override suspend fun insertGame(vararg data: GamePagingDbEntity) {
        gamePagingDao.insertGame(*data)
    }

    override fun loadGame(): DataSource.Factory<Int, GamePagingDbEntity> {
        return gamePagingDao.loadGame()
    }
}
