import com.google.gson.annotations.SerializedName

data class Nl(

	@SerializedName("last_updated_diff_for_humans") val last_updated_diff_for_humans: String,
	@SerializedName("name") val name: String,
	@SerializedName("description") val description: String
)