package asterixorobelix.routedetail.ui.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailTabViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = DetailFragment.tabsText.count()

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                WaypointsFragment.newInstance()
            }
            1 -> {
                MapFragment.newInstance()
            }
            else -> {
                return CommentsFragment.newInstance()
            }
        }
    }
}