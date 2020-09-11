package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import asterixorobelix.routedetail.databinding.LayoutRouteDescriptionBinding

class DetailDescriptionViewHolder(private val binding: LayoutRouteDescriptionBinding) :
    BaseViewHolder<Descriptionable>(binding) {

    fun bind(item: Descriptionable) {
        binding.apply {
            distance.text = "${item.distance} Kilometers"
            days.text = "${item.days} Days"
            waypoints.text = "${item.wayPointCount} Waypoints"

            description.text = item.description
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
    }
}