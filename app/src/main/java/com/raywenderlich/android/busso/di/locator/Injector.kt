package com.raywenderlich.android.busso.di.locator

interface Injector<A> {
    fun inject(target: A)
}