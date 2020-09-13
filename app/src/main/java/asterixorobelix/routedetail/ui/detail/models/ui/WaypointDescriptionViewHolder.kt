package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import asterixorobelix.routedetail.databinding.LayoutWaypointDescriptionBinding
import asterixorobelix.routedetail.ui.detail.models.api.Waypoint

class WaypointDescriptionViewHolder(private val binding: LayoutWaypointDescriptionBinding) :
    BaseViewHolder<Waypoint>(binding) {

    fun bind(item: Waypoint) {
        binding.apply {
            waypointTitle.text = item.name
            waypointSubtitle.text = item.address
            waypointDescription.text = item.description

            distanceText.text = item.distance
            timeText.text = item.duration
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): WaypointDescriptionViewHolder {
            return WaypointDescriptionViewHolder(
                LayoutWaypointDescriptionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}