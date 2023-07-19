package dev.hyuwah.demistifyingdagger2.di

import android.content.Context
import dagger.Component
import dev.hyuwah.core.di.CoreProvider
import dev.hyuwah.core.di.FeatureScope
import dev.hyuwah.core.di.coreProvider
import dev.hyuwah.demistifyingdagger2.MainActivity

@FeatureScope
@Component(
    modules = [MainFeatureViewModelModule::class],
    dependencies = [CoreProvider::class]
)
interface MainFeatureComponent {

    companion object {
        fun injector(context: Context): MainFeatureComponent {
            return DaggerMainFeatureComponent.factory().create(context.coreProvider())
        }
    }

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreProvider): MainFeatureComponent
    }

    fun inject(activity: MainActivity)
}