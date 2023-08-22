package com.example.hygrowmon.repository

import android.content.Context
import android.util.Patterns
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.hygrowmon.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class Repository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth,
    private val datastore: DataStore<Preferences>
) {
    suspend fun setFirstTimeState(state: Boolean) {
        datastore.edit {
            it[booleanPreferencesKey("first_time")] = state
        }
    }

    fun getFirstTimeState() = datastore.data.map {
        it[booleanPreferencesKey("first_time")] ?: true
    }

    fun isLogin() = auth.currentUser != null

    fun register(
        name: String,
        noHp: String,
        email: String,
        password: String,
        confirmPassword:String,
        onSuccess: () -> Unit,
        onFailed: (e: String) -> Unit
    ) {
        if (!Patterns
                .EMAIL_ADDRESS
                .matcher(email)
                .matches()
        ) {
            onFailed("Masukkan Email Yang Benar")
            return
        }

        if(password != confirmPassword){
            onFailed("Password dan Konfirmasi Password tidak sama")
            return
        }

        if(password.length < 8){
            onFailed("Password harus sama atau lebih dari 8 karakter")
            return
        }

        if(noHp.isEmpty() || name.isEmpty()){
            onFailed("Masukkan semua data dengan benar")
            return
        }

        auth.createUserWithEmailAndPassword(
            email, password
        ).addOnSuccessListener {
            if (it.user != null) {
                it.user?.let { user ->
                    firestore
                        .collection("user")
                        .document(user.uid)
                        .set(
                            UserModel(
                                uid = user.uid,
                                name = name,
                                email = email,
                                no_telp = noHp
                            )
                        )
                        .addOnSuccessListener {
                            onSuccess()
                        }
                        .addOnFailureListener {
                            user.delete()
                                .addOnSuccessListener {
                                    onSuccess()
                                }
                                .addOnFailureListener {
                                    onFailed("Gagal dalam melakukan registrasi")
                                }
                        }
                }
            } else {
                onFailed("Gagal Melakukan Registrasi")
            }
        }.addOnFailureListener {
            onFailed(it.message.toString())
        }
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: (e: String) -> Unit
    ) {
        if (!Patterns
                .EMAIL_ADDRESS
                .matcher(email)
                .matches()
        ) {
            onFailed("Masukkan Email Yang Benar")
            return
        }

        if(password.length < 8){
            onFailed("Password harus sama atau lebih dari 8 karakter")
            return
        }

        auth
            .signInWithEmailAndPassword(
                email,
                password
            )
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailed(it.message.toString())
            }
    }
}