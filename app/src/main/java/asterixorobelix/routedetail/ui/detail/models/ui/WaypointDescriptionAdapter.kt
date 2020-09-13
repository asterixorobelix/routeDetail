package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.ui.detail.models.api.Waypoint

class WaypointDescriptionAdapter(private val items: List<Waypoint>) :
    RecyclerView.Adapter<WaypointDescriptionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WaypointDescriptionViewHolder {
        return WaypointDescriptionViewHolder.newInstance(parent)
    }

    override fun getItemViewType(position: Int): Int = R.layout.layout_waypoint_description
    override fun onBindViewHolder(holder: WaypointDescriptionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.count()
}