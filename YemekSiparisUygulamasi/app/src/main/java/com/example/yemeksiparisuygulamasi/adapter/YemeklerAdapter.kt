package com.example.yemeksiparisuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding
import com.example.yemeksiparisuygulamasi.databinding.FragmentAnasayfaBinding
import com.example.yemeksiparisuygulamasi.entity.Yemekler
import com.example.yemeksiparisuygulamasi.fragment.AnasayfaFragmentDirections
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext:Context,var yemeklerListesi:List<Yemekler>)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) :RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        t.textViewYemekAdi.setText("${yemek.yemek_adi}")

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewYemek)
        //t.imageViewYemek.setImageResource(mContext.resources.getIdentifier(yemek.yemek_resim_adi,"drawable",mContext.packageName))

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToYemekDetayFragment(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }


}