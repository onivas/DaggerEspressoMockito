package com.savinoordine.daggerespressomockito;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AlphabetModule {
    @Provides
    @Singleton
    public Alphabet provideAlphabet() {
        return new Alphabet();
    }
}
