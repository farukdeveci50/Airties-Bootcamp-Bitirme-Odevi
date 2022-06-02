package com.example.yemeksiparisuygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SepettekilerCevap(@SerializedName("sepet_yemekler") @Expose var sepet_yemekler:List<Sepettekiler>,
                             @SerializedName("success") @Expose var success:Int) {
}