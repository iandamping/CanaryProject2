package com.junemon.daggerinyourface.cache.util.dto.game


import com.junemon.daggerinyourface.cache.game.paging.GamePagingDbEntity
import com.junemon.daggerinyourface.model.domain.game.GamePagingData


fun GamePagingDbEntity.mapToDomain(): GamePagingData = GamePagingData(gameId, gameName, gameImage)

fun List<GamePagingDbEntity>.mapToDomain(): List<GamePagingData> = map { it.mapToDomain() }

fun GamePagingData.mapToData(): GamePagingDbEntity =
    GamePagingDbEntity(
        gameId,
        gameName,
        gameImage
    )

fun List<GamePagingData>.mapToData(): List<GamePagingDbEntity> = map { it.mapToData() }
