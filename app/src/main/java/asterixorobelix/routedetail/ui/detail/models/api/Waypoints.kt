import com.google.gson.annotations.SerializedName

data class Waypoints (

	@SerializedName("id") val id : Int,
	@SerializedName("route_id") val route_id : Int,
	@SerializedName("order_id") val order_id : Int,
	@SerializedName("object_id") val object_id : String,
	@SerializedName("object_url") val object_url : String,
	@SerializedName("object_type") val object_type : String,
	@SerializedName("address") val address : String,
	@SerializedName("city") val city : String,
	@SerializedName("country_id") val country_id : String,
	@SerializedName("country") val country : String,
	@SerializedName("name") val name : Int,
	@SerializedName("description") val description : String,
	@SerializedName("geo_lat") val geo_lat : String,
	@SerializedName("geo_long") val geo_long : String,
	@SerializedName("geo_lat_dms") val geo_lat_dms : String,
	@SerializedName("geo_long_dms") val geo_long_dms : String,
	@SerializedName("place_id") val place_id : String,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String,
	@SerializedName("meta") val meta : List<String>,
	@SerializedName("distance") val distance : String,
	@SerializedName("duration") val duration : String,
	@SerializedName("category") val category : String,
	@SerializedName("photos") val photos : List<String>
)