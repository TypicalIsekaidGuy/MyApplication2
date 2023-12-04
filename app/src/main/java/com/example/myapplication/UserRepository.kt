package com.example.myapplication

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


class UserRepository {
    lateinit var userToken: String
    var list = mutableStateOf(listOf<Payment>())
    val dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")


    private val userTokenKey = stringPreferencesKey("user_token")
    private val userListKey = stringPreferencesKey("user_list")


    suspend fun saveUserToken(token: String) {
        Context.dataStore.edit { preferences ->
            preferences[userTokenKey] = token
        }
    }

    suspend fun readUserToken(): String {
        return dataStore.data
            .map { preferences -> preferences[userTokenKey] ?: "" }
            .first()
    }

    suspend fun saveUserList(list: String) {
        dataStore.edit { preferences ->
            preferences[userListKey] = list
        }
    }

    suspend fun readUserList(): String {
        return dataStore.data
            .map { preferences -> preferences[userListKey] ?: "" }
            .first()
    }

}