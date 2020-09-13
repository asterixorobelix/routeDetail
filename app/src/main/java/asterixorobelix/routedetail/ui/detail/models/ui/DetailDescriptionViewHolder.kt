package asterixorobelix.routedetail.ui.detail.models.ui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.databinding.LayoutRouteDescriptionBinding
import asterixorobelix.routedetail.loadImageFromURLSetVisibility

class DetailDescriptionViewHolder(private val binding: LayoutRouteDescriptionBinding) :
    BaseViewHolder<Descriptionable>(binding) {

    fun bind(item: Descriptionable) {
        binding.apply {
            distance.text = "${item.distance} ${this.root.context.getString(R.string.kilometers)}"
            days.text = "${item.days} ${this.root.context.getString(R.string.days)}"
            waypoints.text =
                "${item.wayPointCount} ${this.root.context.getString(R.string.waypoints)}"

            description.apply {
                text = item.description
                maxLines = MIN_LINES
                setOnClickListener {
                    maxLines = if (maxLines == MAX_LINES) MIN_LINES else MAX_LINES
                }
            }

            descriptionExpandArrow.setOnClickListener {
                description.maxLines =
                    if (description.maxLines == MAX_LINES) MIN_LINES else MAX_LINES
            }

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.BOTTOM_TOP,
                intArrayOf(
                    Color.parseColor("#00000000"),
                    Color.parseColor("#00000000"),
                    Color.parseColor("#ffdddddd")
                )
            )
            gradientDrawable.cornerRadius = 0f;

            profile.background = gradientDrawable;

            profileName.text = item.profileName

            profileImage.apply {
                clipToOutline = true
                loadImageFromURLSetVisibility(item.profileImageUrl)
            }
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): DetailDescriptionViewHolder {
            return DetailDescriptionViewHolder(
                LayoutRouteDescriptionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        const val MIN_LINES = 4
        const val MAX_LINES = Int.MAX_VALUE
    }
}