package com.savinoordine.daggerespressomockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CommonModule {

    @Provides
    @Singleton
    public Alphabet provideAlphabet() {
        return new Alphabet();
    }

    @Provides
    @Singleton
    public DataSource provideDataSource() {
        return new DataSource();
    }
}
