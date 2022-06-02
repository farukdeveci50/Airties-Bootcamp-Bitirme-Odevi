package com.example.yemeksiparisuygulamasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparisuygulamasi.entity.*
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import com.example.yemeksiparisuygulamasi.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    var ydao:YemeklerDaoInterface

    init {
        ydao = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }


    var sepettekiYemeklerListesi:MutableLiveData<List<Sepettekiler>>
    init {
        ydao = ApiUtils.getYemeklerDaoInterface()
        sepettekiYemeklerListesi = MutableLiveData()
    }

    fun sepettekiYemekleriGetir() : MutableLiveData<List<Sepettekiler>>{
        return sepettekiYemeklerListesi
    }





    fun yemekEkle(sepet_yemek_id:String, yemek_adi:String, yemek_resim_adi:String,
                  yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        ydao.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val basari = response.body().success
                val mesaj = response.body().message
                Log.e("Yemek Kayit","$basari - $mesaj")
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }

    fun yemekSil(sepet_yemek_id:String, yemek_adi:String, yemek_resim_adi:String,
                 yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        //Log.e("Yemek Sil","$sepet_yemek_id,$yemek_adi")
        ydao.yemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val basari = response.body().success
                val mesaj = response.body().message
                Log.e("Yemek Sil","$basari - $mesaj")
                tumSepettekiYemekleriAl(kullanici_adi)


            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })

    }

    fun tumYemekleriAl(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }


    fun tumSepettekiYemekleriAl(kullanici_adi: String){
        ydao.tumSepettekiler(kullanici_adi).enqueue(object : Callback<SepettekilerCevap>{
            override fun onResponse(call: Call<SepettekilerCevap>, response: Response<SepettekilerCevap>) {
                val liste = response.body().sepet_yemekler
                sepettekiYemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<SepettekilerCevap>?, t: Throwable?) {}
        })
    }
}