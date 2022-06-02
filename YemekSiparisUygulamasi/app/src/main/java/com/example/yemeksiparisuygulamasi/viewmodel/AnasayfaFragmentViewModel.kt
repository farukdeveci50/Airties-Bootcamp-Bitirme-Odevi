package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.entity.Yemekler
import com.example.yemeksiparisuygulamasi.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel:ViewModel() {
    val yrepo = YemeklerDaoRepository()
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}