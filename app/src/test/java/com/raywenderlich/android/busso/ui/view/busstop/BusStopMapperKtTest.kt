package com.raywenderlich.android.busso.ui.view.busstop

import com.raywenderlich.android.busso.model.BusStop
import com.raywenderlich.android.location.api.model.GeoLocation
import junit.framework.TestCase

class BusStopMapperKtTest : TestCase() {

    fun testMapBusStop() {
        // 1
        val inputBusStop = BusStop(
            "id",
            "stopName",
            GeoLocation(1.0, 2.0),
            "direction",
            "indicator",
            123F
        )
        // 2
        val expectedViewModel = BusStopViewModel(
            "id",
            "stopName",
            "direction",
            "indicator",
            "123 m"
        )
        // 3
        assertEquals(expectedViewModel, mapBusStop(inputBusStop))
    }

    fun testTestMapBusStop() {}
}