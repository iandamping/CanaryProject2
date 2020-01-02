package com.junemon.daggerinyourface.cache.util.dto.game

import com.junemon.daggerinyourface.cache.game.paging.GamePagingDbEntity
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.data.remote.game.GamesPagingEntity


fun GamesPagingEntity.mapToDatabase(): GamePagingDbEntity =
    GamePagingDbEntity(
        id,
        name,
        backgroundImage
    )

fun List<GamesPagingEntity>.mapToDatabase(): List<GamePagingDbEntity> = map { it.mapToDatabase() }

fun GamesPagingEntity.mapToDomain(): GamePagingData =
    GamePagingData(id, name, backgroundImage)

fun List<GamesPagingEntity>.mapToDomain(): List<GamePagingData> = map { it.mapToDomain() }
