package com.raywenderlich.android.busso.di.locator

import androidx.fragment.app.Fragment
import com.raywenderlich.android.busso.network.BussoEndpoint
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListPresenter
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListPresenterImpl
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListViewBinder
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListViewBinderImpl
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.ui.navigation.Navigator
import io.reactivex.Observable

const val BUSSTOP_LIST_PRESENTER = " BusStopListPresenter"
const val BUSSTOP_LIST_VIEWBINDER = " BusStopListViewBinder"


class FragmentServiceLocator(
    val fragment: Fragment
) : ServiceLocator {
    var activityServiceLocator: ServiceLocator? = null
    var busStopListPresenter: BusStopListPresenter? = null
    var busStopListViewBinder: BusStopListViewBinder? = null

    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun <A : Any> lookUp(name: String): A = when (name) {
        BUSSTOP_LIST_PRESENTER -> {
            // 1
            if (busStopListPresenter == null) {
                // 2
                val navigator: Navigator =
                    activityServiceLocator!!.lookUp(NAVIGATOR)
                // 2
                val locationObservable: Observable<LocationEvent> =
                    activityServiceLocator!!.lookUp(
                        LOCATION_OBSERVABLES
                    )
                // 2
                val bussoEndpoint: BussoEndpoint =
                    activityServiceLocator!!.lookUp(BUSSO_ENDPOINT)
                busStopListPresenter = BusStopListPresenterImpl(
                    navigator,
                    locationObservable,
                    bussoEndpoint
                )
            }
            busStopListPresenter
        }
        BUSSTOP_LIST_VIEWBINDER -> {
            // 1
            if (busStopListViewBinder == null) {
                // 2
                val busStopListPresenter: BusStopListPresenter =
                    lookUp(BUSSTOP_LIST_PRESENTER)
                busStopListViewBinder =
                    BusStopListViewBinderImpl(busStopListPresenter)
            }
            busStopListViewBinder
        }
        else -> activityServiceLocator?.lookUp<A>(name)
            ?: throw IllegalArgumentException("No component lookup for the key: $name")
    } as A
}