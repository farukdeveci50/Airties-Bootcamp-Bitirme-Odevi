package com.example.yemeksiparisuygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekDetayBinding
import com.example.yemeksiparisuygulamasi.viewmodel.YemekDetayFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class YemekDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekDetayBinding
    private lateinit var viewModel:YemekDetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay,container,false)

        tasarim.yemekDetayToolbarBaslik = "Yemek Detayı"
        tasarim.yemekDetayFragment = this


        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        tasarim.gelenYemekNesnesi = gelenYemek
        secilenYemek(gelenYemek.yemek_resim_adi)


        tasarim.fabEkle.setOnClickListener {
            Snackbar.make(it,"${gelenYemek.yemek_adi} Sepete Eklendi!",Snackbar.LENGTH_SHORT).show()
            viewModel.Ekle(gelenYemek.yemek_id,gelenYemek.yemek_adi,gelenYemek.yemek_resim_adi,gelenYemek.yemek_fiyat,"1","farukdeveci")
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekDetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabSepeteGit(v:View){
        Navigation.findNavController(v).navigate(R.id.action_yemekDetayFragment_to_yemekSepetiFragment)
    }

    fun fabAnasayfayaGit(v:View){
        Navigation.findNavController(v).navigate(R.id.action_yemekDetayFragment_to_anasayfaFragment)
    }

    fun secilenYemek(resimAdi:String){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Picasso.get().load(url).into(tasarim.imageView)
    }



}