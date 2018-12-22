package com.example.geonho.appjam17.util

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkAPI {

    @POST("auth/signin")
    @FormUrlEncoded
    fun signIn(@Field("id") id: String, @Field("password") pw: String): Call<ResponseBody>

    @POST("auth/signup")
    @FormUrlEncoded
    fun signUp(
        @Field("id") id: String,
        @Field("password") pw: String,
        @Field("shopName") shopName: String,
        @Field("shopNumber") number: String,
        @Field("address") address: String
    ): Call<ResponseBody>

    @GET("shop")
    fun getShopById(@Query("shopId") id: String): Call<ResponseBody>

    @GET("shop")
    fun getAllShop(): Call<ResponseBody>

    @FormUrlEncoded
    @POST("shop/favorite")
    fun postFavorite(@Field("userId") userId: String, @Field("shopId") shopId: String): Call<ResponseBody>

    @Multipart
    @POST("shop/thumbnail")
    fun postShopThumbnail(
        @Part thumbnail: MultipartBody.Part,
        @Part("shopId") shopId: RequestBody // 절대 귀찮아서 그런거임
    ): Call<ResponseBody>

    @Multipart
    @POST("shop")
    fun postUpdateFlowers(
        @Part images: Array<MultipartBody.Part>,
        @Part("shopId") shopId: String,
        @Part("flowers") flowers: String
    ): Call<ResponseBody> // flowers -> Gson().toJson(Array<Flower>)

    @FormUrlEncoded
    @POST("shop/desc")
    fun postShopDesc(
        @Field("shopId") shopId: String,
        @Field("desc") desc: String
    ): Call<ResponseBody>
}
