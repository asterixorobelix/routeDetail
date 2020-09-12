package asterixorobelix.routedetail.ui.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.ui.detail.models.api.RouteDetail
import com.google.gson.Gson
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

class DetailRepository(private val gson: Gson, private val context: Context) {
    val routeDetail: MutableLiveData<RouteDetail> = MutableLiveData(getRouteDetail())

    fun getRouteDetail(): RouteDetail {
        val rawRoute = context.resources.openRawResource(R.raw.route)
        val routeReader = BufferedReader(InputStreamReader(rawRoute))

        return gson.fromJson(routeReader, RouteDetail::class.java)
    }
}