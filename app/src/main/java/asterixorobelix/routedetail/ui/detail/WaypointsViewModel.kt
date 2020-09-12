package asterixorobelix.routedetail.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class WaypointsViewModel(private val detailRepository: DetailRepository) : ViewModel() {
    val routeDetail = liveData {
        emit(detailRepository.getRouteDetail())
    }
}