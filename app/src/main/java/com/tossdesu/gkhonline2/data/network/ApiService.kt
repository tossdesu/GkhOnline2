package com.tossdesu.gkhonline2.data.network

import com.tossdesu.gkhonline2.data.network.entity.SignInRequestBody
import com.tossdesu.gkhonline2.data.network.entity.SignInResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/signin/app")
    suspend fun signIn(@Body body: SignInRequestBody): SignInResponseBody
}