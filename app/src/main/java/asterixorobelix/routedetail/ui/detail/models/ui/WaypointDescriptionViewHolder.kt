package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.databinding.LayoutWaypointDescriptionBinding
import asterixorobelix.routedetail.loadImageFromIDSetVisibility
import asterixorobelix.routedetail.setVisibleOrGone
import asterixorobelix.routedetail.ui.detail.models.api.Waypoint
import asterixorobelix.routedetail.ui.detail.models.api.WaypointType

class WaypointDescriptionViewHolder(private val binding: LayoutWaypointDescriptionBinding) :
    BaseViewHolder<Waypoint>(binding) {

    fun bind(item: Waypoint) {
        binding.apply {
            waypointTitle.apply {
                text =
                    if (item.type == WaypointType.Day) "${root.context.getString(R.string.day)} ${item.name}" else item.name
                this.setTextColor(resources.getColor(if (item.type == WaypointType.Day) R.color.colorAccent else android.R.color.black))
                waypointSubtitle.setVisibleOrGone(item.type != WaypointType.Day)
                measurementsLayout.setVisibleOrGone(item.type != WaypointType.Day)
                waypointDescription.setVisibleOrGone(item.type != WaypointType.Day)
                imagesViewPager.setVisibleOrGone(item.type != WaypointType.Day)
                bottomLine.setVisibleOrGone(item.type != WaypointType.Day)
                topLine.setVisibleOrGone(item.type != WaypointType.Day)
            }

            if (item.photos.isNotEmpty()) {
                imagesViewPager.adapter = WaypointImageAdapter(item.photos)
            }

            geoWaypointDescriptionImage.loadImageFromIDSetVisibility(
                R.drawable.more_horizontal,
                item.type != WaypointType.Day
            )

            waypointSubtitle.text = item.address

            item.description?.let {
                waypointDescription.text = HtmlCompat.fromHtml(item.description, 0)
                waypointDescription.maxLines =
                    if (waypointDescription.maxLines == MAX_LINES) MIN_LINES else MAX_LINES
            }

            waypointDescription.setOnClickListener {
                waypointDescription.maxLines =
                    if (waypointDescription.maxLines == MAX_LINES) MIN_LINES else MAX_LINES
            }

            geoWaypointDescriptionImage.setVisibleOrGone(item.type == WaypointType.Geo)

            item.distance?.toIntOrNull()?.let {
                distanceText.text = HtmlCompat.fromHtml(
                    "${
                        root.context.getString(R.string.distance)
                    } <strong>${it / METRES_TO_KILOMETERS} ${
                        root.context.getString(R.string.kilometers)
                    }</strong>", 0
                )
            }

            waypointIcon.loadImageFromIDSetVisibility(if (item.type == WaypointType.Day) R.drawable.day_icon else R.drawable.pin_drop)

            item.duration?.toDoubleOrNull()?.let {
                timeText.text = HtmlCompat.fromHtml(
                    "${
                        root.context.getString(R.string.hours)
                    } <strong>${"%.2f".format((it / (60 * 60)))} ${
                        root.context.getString(R.string.hours_postfix)
                    }</strong>", 0
                )
            }
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

        const val MIN_LINES = 3
        const val MAX_LINES = Int.MAX_VALUE

        const val METRES_TO_KILOMETERS = 1000
    }
}