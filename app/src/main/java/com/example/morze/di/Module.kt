package com.example.morze.di

import android.content.Context
import android.media.MediaPlayer
import com.example.morze.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideMediaPlayer(@ApplicationContext context: Context) =
        MediaPlayer.create(context, R.raw.beep)
}