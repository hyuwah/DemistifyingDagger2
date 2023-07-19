package dev.hyuwah.demistifyingdagger2.di

import dev.hyuwah.core.di.CoreProvider

/**
 * Pure interface, collection of singleton components with it's exposed object
 * Real/Dagger AppComponent will extend this interface
 */
interface AppProvider: CoreProvider {
}