package asterixorobelix.routedetail.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asterixorobelix.routedetail.ui.detail.models.api.RouteDetail

class WaypointsViewModel(private val detailRepository: DetailRepository): ViewModel() {
    val routeDetail: MutableLiveData<RouteDetail> = MutableLiveData(detailRepository.getRouteDetail())
}