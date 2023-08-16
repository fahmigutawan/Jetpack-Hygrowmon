package com.example.hygrowmon.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.hygrowmon.repository.Repository
import com.example.hygrowmon.repository.dataStore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideDatastore(
        @ApplicationContext context:Context
    ) = context.dataStore

    @Provides
    @Singleton
    fun provideRepository(
        firestore: FirebaseFirestore,
        auth: FirebaseAuth,
        dataStore: DataStore<Preferences>
    ) = Repository(
        firestore = firestore,
        auth = auth,
        datastore = dataStore
    )
}