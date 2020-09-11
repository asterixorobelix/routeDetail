package asterixorobelix.routedetail.ui.detail.models.api

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("iso_3166_2") val isoCode: String,
    @SerializedName("phone_country_prefix") val phoneCode: String,
)