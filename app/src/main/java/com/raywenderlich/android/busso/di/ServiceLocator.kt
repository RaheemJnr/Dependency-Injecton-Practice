package com.raywenderlich.android.busso.di

/**
 * Returns the object of type A bound to a specific name
 * **/
interface ServiceLocator {
    fun <A : Any> lookUp(name: String): A
}
