package asterixorobelix.routedetail

import android.app.Application
import asterixorobelix.routedetail.ui.detail.detailModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RouteDetailApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RouteDetailApplication)
            modules(listOf(detailModule))
        }
    }
}