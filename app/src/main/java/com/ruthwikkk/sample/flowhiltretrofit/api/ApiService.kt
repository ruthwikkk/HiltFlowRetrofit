package com.ruthwikkk.sample.flowhiltretrofit.api

import com.ruthwikkk.sample.flowhiltretrofit.models.Rocket
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/rockets")
    suspend fun getRockets(): List<Rocket>
}