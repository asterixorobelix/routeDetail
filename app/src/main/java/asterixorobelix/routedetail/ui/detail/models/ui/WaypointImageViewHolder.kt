package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import asterixorobelix.routedetail.databinding.LayoutWaypointImageBinding
import asterixorobelix.routedetail.loadImageFromURLSetVisibility
import asterixorobelix.routedetail.ui.detail.models.api.Photo

class WaypointImageViewHolder(private val binding: LayoutWaypointImageBinding) :
    BaseViewHolder<Photo>(binding) {

    fun bind(item: Photo) {
        binding.waypointImage.apply {
            clipToOutline = true
            loadImageFromURLSetVisibility(item.urls.thumb)
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): WaypointImageViewHolder {
            return WaypointImageViewHolder(
                LayoutWaypointImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}