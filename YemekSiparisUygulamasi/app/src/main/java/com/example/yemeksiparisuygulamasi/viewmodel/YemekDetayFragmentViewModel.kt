package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.repo.YemeklerDaoRepository

class YemekDetayFragmentViewModel : ViewModel() {
    val yrepo = YemeklerDaoRepository()

    fun Ekle(sepet_yemek_id:String,yemek_adi:String, yemek_resim_adi:String,
             yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        yrepo.yemekEkle(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    }
}