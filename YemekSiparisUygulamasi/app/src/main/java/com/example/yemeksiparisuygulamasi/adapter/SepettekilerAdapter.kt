package com.example.yemeksiparisuygulamasi.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.databinding.Card2TasarimBinding
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding
import com.example.yemeksiparisuygulamasi.entity.Sepettekiler
import com.example.yemeksiparisuygulamasi.viewmodel.YemekSepetiFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepettekilerAdapter(var mContext:Context,
                          var sepettekilerListesi:List<Sepettekiler>,
                          var viewModel:YemekSepetiFragmentViewModel)
    : RecyclerView.Adapter<SepettekilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:Card2TasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:Card2TasarimBinding
        init {
            this.tasarim=tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = Card2TasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepetYemek = sepettekilerListesi.get(position)
        val t = holder.tasarim

        t.textView2YemekAdi.setText("${sepetYemek.yemek_adi}")
        t.textView2YemekFiyati.setText("${sepetYemek.yemek_fiyat} ₺")
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepetYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageView2Yemek)

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${sepetYemek.yemek_adi} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    //Log.e("Yemek Sil",sepetYemek.sepet_yemek_id.toString())
                    viewModel.sil(sepetYemek.sepet_yemek_id,sepetYemek.yemek_adi,sepetYemek.yemek_resim_adi,sepetYemek.yemek_fiyat,sepetYemek.yemek_siparis_adet,sepetYemek.kullanici_adi)
                }
                .show()
            //viewModel.sepettekiYemekleriYukle()
        }
    }

    override fun getItemCount(): Int {
        return sepettekilerListesi.size
    }
}