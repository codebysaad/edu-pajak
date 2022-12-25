package com.saadfauzi.edupajak.injection

import android.app.Application
import androidx.room.Room
import com.saadfauzi.edupajak.data.local.PajakDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleLocal {
    @Provides
    @Singleton
    fun provideDatabase(application: Application) = Room
        .databaseBuilder(application, PajakDatabase::class.java, "taxes.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideDao(database: PajakDatabase) = database.pajakDao()
}