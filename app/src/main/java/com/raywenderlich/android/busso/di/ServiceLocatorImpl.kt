package com.raywenderlich.android.busso.di

class ServiceLocatorImpl : ServiceLocator {
    override fun <A : Any> lookUp(name: String): A = when (name) {
        else -> throw
        IllegalArgumentException("No component lookup for the key: $name")
    }
}