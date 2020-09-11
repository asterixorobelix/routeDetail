import com.google.gson.annotations.SerializedName

data class Photo (
	@SerializedName("id") val id : Int,
	@SerializedName("user_id") val user_id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("filename") val filename : String,
	@SerializedName("filesize") val filesize : Int,
	@SerializedName("urls") val urls : Urls,
	@SerializedName("order_id") val order_id : Int
)