package asterixorobelix.routedetail.ui.detail.models.api

import com.google.gson.annotations.SerializedName

data class De (
	@SerializedName("last_updated_diff_for_humans") val last_updated_diff_for_humans : String,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String
)