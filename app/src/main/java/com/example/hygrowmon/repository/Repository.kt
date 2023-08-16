package com.example.hygrowmon.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class Repository @Inject constructor(
    private val firestore:FirebaseFirestore,
    private val auth:FirebaseAuth,
    private val datastore:DataStore<Preferences>
) {
    suspend fun setFirstTimeState(state:Boolean){
        datastore.edit {
            it[booleanPreferencesKey("first_time")] = state
        }
    }

    fun getFirstTimeState() = datastore.data.map {
        it[booleanPreferencesKey("first_time")] ?: true
    }

    fun isLogin() = auth.currentUser != null
}