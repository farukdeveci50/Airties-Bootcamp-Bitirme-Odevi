package com.example.yemeksiparisuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.adapter.SepettekilerAdapter
import com.example.yemeksiparisuygulamasi.adapter.YemeklerAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekSepetiBinding
import com.example.yemeksiparisuygulamasi.entity.Sepettekiler
import com.example.yemeksiparisuygulamasi.viewmodel.YemekSepetiFragmentViewModel

class YemekSepetiFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekSepetiBinding
    private lateinit var viewModel:YemekSepetiFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_sepeti,container,false)

        tasarim.yemekSepetiToolbarBaslik = "Yemek Sepeti"
        tasarim.yemekSepetiFragment = this

        viewModel.sepettekiYemeklerListesi.observe(viewLifecycleOwner){
            val adapter = SepettekilerAdapter(requireContext(),it,viewModel)
            tasarim.sepettekilerAdapter = adapter
        }




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekSepetiFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabAnasayfayaGit(v:View){
        Navigation.findNavController(v).navigate(R.id.action_yemekSepetiFragment_to_anasayfaFragment)
    }



}