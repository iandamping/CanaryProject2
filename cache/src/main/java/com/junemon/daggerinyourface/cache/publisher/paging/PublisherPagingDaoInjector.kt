package com.junemon.daggerinyourface.cache.publisher.paging

import androidx.paging.DataSource
import com.junemon.daggerinyourface.cache.GameDatabase
import javax.inject.Inject

class PublisherPagingDaoInjector @Inject constructor(private val database: GameDatabase) :
    PublisherPagingDao {
    override suspend fun insertPublisher(vararg data: PublisherPagingDbEntity) {
        database.publisherPagingDao().insertPublisher(*data)
    }

    override fun loadPublisher(): DataSource.Factory<Int, PublisherPagingDbEntity> {
        return database.publisherPagingDao().loadPublisher()
    }
}
