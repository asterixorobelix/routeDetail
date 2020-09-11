import com.google.gson.annotations.SerializedName

data class User (
	@SerializedName("id") val id : Int,
	@SerializedName("username") val username : String,
	@SerializedName("displayname") val displayname : String,
	@SerializedName("tagline") val tagline : String,
	@SerializedName("language") val language : String,
	@SerializedName("photo") val photo : Photo
)