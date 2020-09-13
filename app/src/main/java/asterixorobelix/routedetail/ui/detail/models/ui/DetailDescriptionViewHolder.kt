package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import asterixorobelix.routedetail.databinding.LayoutRouteDescriptionBinding
import asterixorobelix.routedetail.loadImageFromURLSetVisibility

class DetailDescriptionViewHolder(private val binding: LayoutRouteDescriptionBinding) :
    BaseViewHolder<Descriptionable>(binding) {

    fun bind(item: Descriptionable) {
        binding.apply {
            distance.text = "${item.distance} Kilometers"
            days.text = "${item.days} Days"
            waypoints.text = "${item.wayPointCount} Waypoints"

            description.apply {
                text = item.description
                maxLines = MIN_LINES
                setOnClickListener {
                    maxLines = if (maxLines == MAX_LINES) MIN_LINES else MAX_LINES
                }
            }

            profileName.text = item.profileName
            profileAll.text = "All"

            profileImage.loadImageFromURLSetVisibility(item.profileImageUrl)
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