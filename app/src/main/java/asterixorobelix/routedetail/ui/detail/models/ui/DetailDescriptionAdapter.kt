package asterixorobelix.routedetail.ui.detail.models.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.routedetail.R

class DetailDescriptionAdapter(private val description: Descriptionable) :
    RecyclerView.Adapter<DetailDescriptionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailDescriptionViewHolder {
        return DetailDescriptionViewHolder.newInstance(parent)
    }

    override fun getItemViewType(position: Int): Int = R.layout.layout_route_description
    override fun onBindViewHolder(holder: DetailDescriptionViewHolder, position: Int) {
        holder.bind(description)
    }

    override fun getItemCount(): Int = 1
}