package com.savinoordine.daggerespressomockito;

import dagger.Module;
import dagger.Provides;

@Module
public class MockAlphabetModule extends AlphabetModule{

    private Alphabet alphabet;

    public MockAlphabetModule(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Provides
    public Alphabet provideAlphabet() {
        return alphabet;
    }
}