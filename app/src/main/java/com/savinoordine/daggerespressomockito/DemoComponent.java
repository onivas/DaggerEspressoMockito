package com.savinoordine.daggerespressomockito;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AlphabetModule.class)
public interface DemoComponent {
    void inject(MainActivity mainActivity);
}
