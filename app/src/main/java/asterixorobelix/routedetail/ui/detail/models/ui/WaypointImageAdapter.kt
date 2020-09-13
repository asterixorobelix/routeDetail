package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.ui.detail.models.api.Photo

class WaypointImageAdapter(private val items: List<Photo>) :
    RecyclerView.Adapter<WaypointImageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WaypointImageViewHolder {
        return WaypointImageViewHolder.newInstance(parent)
    }

    override fun getItemViewType(position: Int): Int = R.layout.layout_waypoint_image
    override fun onBindViewHolder(holder: WaypointImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.count()
}