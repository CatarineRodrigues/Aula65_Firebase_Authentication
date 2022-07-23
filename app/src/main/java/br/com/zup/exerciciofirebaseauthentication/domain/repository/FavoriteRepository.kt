package br.com.zup.exerciciofirebaseauthentication.domain.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.ktx.Firebase

class FavoriteRepository {
    private val authentication: FirebaseAuth = Firebase.auth
    private val database = FirebaseDatabase.getInstance()
    private val reference = database.getReference()

    fun getDatabaseReference() = reference

    fun getListMessageFavorited(): Query {
        return reference.orderByValue()
    }
}