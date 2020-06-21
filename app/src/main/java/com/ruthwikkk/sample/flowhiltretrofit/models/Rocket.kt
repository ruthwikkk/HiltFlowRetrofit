package com.ruthwikkk.sample.flowhiltretrofit.models

import com.google.gson.annotations.SerializedName

class Rocket {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("rocket_name")
    var name: String? = null

    @SerializedName("rocket_type")
    var type: String? = null

    @SerializedName("flickr_images")
    var flickrImages: ArrayList<String>? = null

}