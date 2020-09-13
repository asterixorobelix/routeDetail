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
    private val waypointsViewModel: WaypointsViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_waypoints, container, false)
        viewBinding?.apply {
            recyclerView = waypointsRecycler
        }
        waypointsViewModel.routeDetail.observe(viewLifecycleOwner, Observer { routeDetails ->
            recyclerView?.adapter = ConcatAdapter(
                DetailDescriptionAdapter(
                    Descriptionable(
                        routeDetails.distance,
                        routeDetails.days,
                        routeDetails.waypoint_count,
                        routeDetails.description,
                        routeDetails.user.photo.urls.thumb,
                        routeDetails.user.displayname
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