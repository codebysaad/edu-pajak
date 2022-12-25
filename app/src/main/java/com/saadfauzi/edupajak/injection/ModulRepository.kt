package com.saadfauzi.edupajak.injection

import com.saadfauzi.edupajak.data.local.PajakDao
import com.saadfauzi.edupajak.data.repository.PajakRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ModulRepository {
    @Provides
    @ViewModelScoped
    fun provideRepository(pajakDao: PajakDao) = PajakRepository(pajakDao)
}