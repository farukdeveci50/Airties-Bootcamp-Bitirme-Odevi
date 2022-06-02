package com.example.yemeksiparisuygulamasi.retrofit

import com.example.yemeksiparisuygulamasi.entity.CRUDCevap
import com.example.yemeksiparisuygulamasi.entity.SepettekilerCevap
import com.example.yemeksiparisuygulamasi.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemekEkle(@Field("yemek_adi") yemek_adi:String,
                  @Field("yemek_resim_adi") yemek_resim_adi:String,
                  @Field("yemek_fiyat") yemek_fiyat:String,
                  @Field("yemek_siparis_adet") yemek_siparis_adet:String,
                  @Field("kullanici_adi") kullanici_adi:String) : Call<CRUDCevap>


    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun tumSepettekiler(@Field("kullanici_adi") kullanici_adi: String) : Call<SepettekilerCevap>


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun yemekSil(@Field("sepet_yemek_id") sepet_yemek_id:String,
                 @Field("kullanici_adi") kullanici_adi: String) : Call<CRUDCevap>
}