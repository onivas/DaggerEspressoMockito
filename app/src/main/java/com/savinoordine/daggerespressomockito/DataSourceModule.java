package com.savinoordine.daggerespressomockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {

    @Provides
    @Singleton
    public DataSource provideDataSource() {
        return new DataSource();
    }
}
