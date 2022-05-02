package com.raywenderlich.android.busso.permission

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.raywenderlich.android.location.api.permissions.GeoLocationPermissionChecker

class GeoLocationPermissionCheckerImpl(val context: Context) :
    GeoLocationPermissionChecker {

    override val isPermissionGiven: Boolean
        get() = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
}