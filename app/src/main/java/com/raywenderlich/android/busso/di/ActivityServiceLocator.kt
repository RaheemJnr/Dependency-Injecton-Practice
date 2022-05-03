package com.raywenderlich.android.busso.di



import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import java.lang.IllegalArgumentException

const val NAVIGATOR = "Navigator"

val activityServiceLocatorFactory:
        ServiceLocatorFactory<AppCompatActivity> = { activity: AppCompatActivity ->
    ActivityServiceLocator(activity)
}

class ActivityServiceLocator(private val activity: AppCompatActivity) : ServiceLocator {

    var applicationServiceLocator: ServiceLocator? = null

    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun <A : Any> lookUp(name: String): A = when (name) {
        NAVIGATOR -> NavigatorImpl(activity)
        else -> applicationServiceLocator?.lookUp<A>(name)
            ?: throw IllegalArgumentException("No component lookup for the key: $name")
    } as A
}