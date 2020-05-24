package br.com.psoa.jackpot

import android.app.Application
import br.com.psoa.jackpot.dao.DatabaseModule
import br.com.psoa.jackpot.lotodicas.LotoDicasModule
import br.com.psoa.jackpot.ui.main.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        DatabaseModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        LotoDicasModule::class,
        AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent {

    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /*
     * This is our custom Application class
     * */
    fun inject(jackpotApp: JackpotApp)
}