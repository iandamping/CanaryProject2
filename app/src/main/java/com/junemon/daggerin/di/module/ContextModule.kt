package com.junemon.daggerin.di.module

import android.content.Context
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides


/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
class ContextModule {

    @Provides
    @ApplicationContext
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }
}