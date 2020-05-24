package br.com.psoa.jackpot

import br.com.psoa.jackpot.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}