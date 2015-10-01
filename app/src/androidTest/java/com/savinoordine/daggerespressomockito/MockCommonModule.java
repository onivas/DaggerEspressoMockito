package com.savinoordine.daggerespressomockito;


import dagger.Provides;

public class MockCommonModule extends CommonModule {

    private Alphabet alphabet;
    private DataSource dataSource;

    public MockCommonModule(Alphabet alphabet, DataSource dataSource) {
        this.alphabet = alphabet;
        this.dataSource = dataSource;
    }

    @Provides
    public Alphabet provideAlphabet() {
        return alphabet;
    }

    @Provides
    public DataSource provideDataSource() {
        return dataSource;
    }


}
