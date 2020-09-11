package asterixorobelix.routedetail.ui.detail

import android.content.Context
import asterixorobelix.routedetail.R
import asterixorobelix.routedetail.ui.detail.models.api.RouteDetail
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class DetailRepository(private val gson: Gson, private val context: Context) {

    fun getRouteDetail(): RouteDetail {
        val rawRoute = context.resources.openRawResource(R.raw.route)
        val routeReader = BufferedReader(InputStreamReader(rawRoute))

        return gson.fromJson(routeReader, RouteDetail::class.java)
    }
}