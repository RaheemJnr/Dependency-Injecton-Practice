package com.raywenderlich.android.busso.di.injecter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.raywenderlich.android.busso.di.locator.*
import com.raywenderlich.android.busso.lookUp
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment

const val FRAGMENT_LOCATOR_FACTORY = "FragmentLocatorFactory"

object BusStopFragmentInjector : Injector<BusStopFragment> {
    override fun inject(target: BusStopFragment) {
        val parentActivity = target.context as AppCompatActivity
        val activityServiceLocator =
            parentActivity.lookUp<ServiceLocatorFactory<AppCompatActivity>>(ACTIVITY_LOCATOR_FACTORY)
                .invoke(parentActivity)
        val fragmentServiceLocator =
            activityServiceLocator
                .lookUp<ServiceLocatorFactory<Fragment>>(FRAGMENT_LOCATOR_FACTORY)
                .invoke(target)
        with(target) {
            busStopListPresenter = fragmentServiceLocator.lookUp(BUSSTOP_LIST_PRESENTER)
            busStopListViewBinder = fragmentServiceLocator.lookUp(BUSSTOP_LIST_VIEWBINDER)
        }
    }
}