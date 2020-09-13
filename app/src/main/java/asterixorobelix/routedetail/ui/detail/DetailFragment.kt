package asterixorobelix.routedetail.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.ToolbarImageHeader
import asterixorobelix.routedetail.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by inject()
    private var binding: FragmentDetailBinding? = null
    private var tabMediator: TabLayoutMediator? = null
    private var viewPagerAdapter: FragmentStateAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)
        detailViewModel.apply {
            routeDetail.observe(viewLifecycleOwner, Observer {routeDetails ->

                (activity as? ToolbarImageHeader)?.apply {
                    setToolbarImage()
                    setToolbarText(routeDetails.name)
                }
            })
        }

        binding?.apply {
            viewPagerAdapter = DetailTabViewPagerAdapter(this@DetailFragment)
            detailViewPager.adapter = viewPagerAdapter

            tabMediator = TabLayoutMediator(detailTabs, detailViewPager) { tab, position ->
                tab.text = tabsText[position]
            }
            tabMediator?.attach()
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabMediator?.detach()
        binding = null
        viewPagerAdapter = null
        tabMediator = null
    }

    companion object {
        val tabsText = listOf("Waypoints", "Map", "Comments")
    }
}