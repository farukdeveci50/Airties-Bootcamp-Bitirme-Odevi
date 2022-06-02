package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.entity.Sepettekiler
import com.example.yemeksiparisuygulamasi.repo.YemeklerDaoRepository

class YemekSepetiFragmentViewModel:ViewModel() {
    val yrepo = YemeklerDaoRepository()
    var sepettekiYemeklerListesi = MutableLiveData<List<Sepettekiler>>()

    init {
        sepettekiYemekleriYukle()
        sepettekiYemeklerListesi = yrepo.sepettekiYemekleriGetir()
    }


    fun sil(sepet_yemek_id:String,yemek_adi:String, yemek_resim_adi:String,
            yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        yrepo.yemekSil(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    }

    fun sepettekiYemekleriYukle(){
        yrepo.tumSepettekiYemekleriAl(kullanici_adi = "farukdeveci")
    }


}