package com.junemon.daggerin.dagger

import com.junemon.daggerin.attribute.DragonAttribute
import com.junemon.daggerin.monster.Dragon
import dagger.Module
import dagger.Provides


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object DragonModule {

    @Provides
    fun provideDragonAttribute():DragonAttribute = DragonAttribute()
}