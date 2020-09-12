package asterixorobelix.routedetail.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class DetailViewModel(val detailRepository: DetailRepository) : ViewModel() {
    val routeDetail = liveData {
        emit(detailRepository.getRouteDetail())
    }
}