package asterixorobelix.routedetail

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.api.load

fun ImageView.loadImageFromURLSetVisibility(
    imageURL: String, visible: Boolean = true, @DrawableRes errorDrawable: Int = R.drawable.profile
) {
    val progressDrawable = createProgressDrawable(context)

    load(imageURL) {
        placeholder(progressDrawable)
        error(errorDrawable)
    }

    setVisibleOrGone(visible)
}

fun View.setVisibleOrGone(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun createProgressDrawable(context: Context): CircularProgressDrawable =
    CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        setColorSchemeColors(R.color.colorAccent)
        start()
    }