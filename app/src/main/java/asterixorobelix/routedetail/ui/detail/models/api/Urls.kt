import com.google.gson.annotations.SerializedName

data class Urls(
	@SerializedName("landscape") val landscape: String,
	@SerializedName("xlarge") val xlarge: String,
	@SerializedName("large") val large: String,
	@SerializedName("medium") val medium: String,
	@SerializedName("article") val article: String,
	@SerializedName("profile") val profile: String,
	@SerializedName("thumb") val thumb: String
)