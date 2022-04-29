package genderizeapp.kotlin.com.genderize

import com.google.gson.annotations.SerializedName
import java.util.*


public class GenderModel {

    @SerializedName("name")
    val name: String? = null

    @SerializedName("gender")
    val gender: String? = null

    @SerializedName("probability")
    val probability: Float? = null

    @SerializedName("count")
    val count: Int? = null
}