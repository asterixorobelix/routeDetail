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
import asterixorobelix.routedetail.databinding.FragmentWaypointsBinding
import asterixorobelix.routedetail.ui.detail.models.ui.Descriptionable
import asterixorobelix.routedetail.ui.detail.models.ui.DetailDescriptionAdapter
import org.koin.android.ext.android.inject

class WaypointsFragment : Fragment() {

    private var viewBinding: FragmentWaypointsBinding? = null
    private var recyclerView: RecyclerView? = null
    private val detailViewModel: DetailViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_waypoints, container, false)
        viewBinding?.apply {
            recyclerView = waypointsRecycler
            recyclerView?.adapter = ConcatAdapter()
        }
        detailViewModel.routeDetail.observe(viewLifecycleOwner, Observer {
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
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
        recyclerView?.adapter = null
        recyclerView = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WaypointsFragment()
    }
}