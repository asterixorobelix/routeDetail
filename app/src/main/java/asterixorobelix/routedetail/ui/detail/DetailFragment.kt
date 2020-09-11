package asterixorobelix.routedetail.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.databinding.FragmentDetailBinding
import asterixorobelix.routedetail.ui.detail.models.ui.Descriptionable
import asterixorobelix.routedetail.ui.detail.models.ui.DetailDescriptionAdapter
import org.koin.android.ext.android.inject

class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by inject()
    private var binding: FragmentDetailBinding? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)
        recyclerView = binding?.detailRecycler
        detailViewModel.apply {
            routeDetail.observe(viewLifecycleOwner, Observer {
                recyclerView?.adapter = ConcatAdapter(
                    DetailDescriptionAdapter(
                        Descriptionable(
                            it.distance,
                            it.days,
                            it.waypoint_count,
                            it.description
                        )
                    )
                )
            })
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        recyclerView?.adapter = null
        recyclerView = null
    }
}