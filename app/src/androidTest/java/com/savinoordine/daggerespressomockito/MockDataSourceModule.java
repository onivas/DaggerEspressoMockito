package com.savinoordine.daggerespressomockito;

import dagger.Provides;

public class MockDataSourceModule extends DataSourceModule {

    private DataSource dataSource;

    public MockDataSourceModule(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Provides
    public DataSource provideDataSource() {
        return dataSource;
    }
}
