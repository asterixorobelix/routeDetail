package asterixorobelix.routedetail.ui.detail

import com.google.gson.Gson
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel(get()) }
    single { DetailRepository(get(), get()) }
    single { Gson() }
    viewModel { WaypointsViewModel(get()) }
}