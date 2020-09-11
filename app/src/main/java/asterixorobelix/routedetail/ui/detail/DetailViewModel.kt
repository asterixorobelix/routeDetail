package asterixorobelix.routedetail.ui.detail

import androidx.lifecycle.ViewModel

class DetailViewModel(private val detailRepository: DetailRepository): ViewModel() {

    init {
        val route = detailRepository.getRouteDetail()
    }
}