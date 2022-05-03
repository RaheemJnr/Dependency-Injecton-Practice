package com.raywenderlich.android.busso.di

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.location.rx.provideRxLocationObservable

const val LOCATION_OBSERVABLES = "LocationObservables"

const val ACTIVITY_LOCATOR_FACTORY = "ActivityLocationFactory"


class ServiceLocatorImpl(val context: Context) : ServiceLocator {
    private val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    private val geoLocationPermissionChecker = GeoLocationPermissionCheckerImpl(context)

    private val locationObservables =
        provideRxLocationObservable(locationManager, geoLocationPermissionChecker)

    @Suppress("IMPLICIT_CAST_TO_ANY","UNCHECKED_CAST")
    @SuppressLint("ServiceCast")
    override fun <A : Any> lookUp(name: String): A = when (name) {
        LOCATION_OBSERVABLES -> locationObservables
        ACTIVITY_LOCATOR_FACTORY -> activityServiceLocatorFactory
        else -> throw
        IllegalArgumentException("No component lookup for the key: $name")
    } as A
}