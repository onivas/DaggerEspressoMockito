package com.savinoordine.daggerespressomockito;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The concept of 'Components' is used to
 * associate modules with injection targets
 */
@Singleton
@Component(modules = CommonModule.class)
public interface DemoComponent {
    void inject(MainActivity mainActivity);
}
