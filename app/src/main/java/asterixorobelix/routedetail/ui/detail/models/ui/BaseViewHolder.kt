package asterixorobelix.routedetail.ui.detail.models.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<I : Any>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
}