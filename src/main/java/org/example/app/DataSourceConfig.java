package org.example.app;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Autowired
    private DbProperties dbProps;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(dbProps.getDbDriver() + dbProps.getDbName())
                .username(dbProps.getUsername())
                .password(dbProps.getPassword())
                .build();
    }

    @PostConstruct
    public void testConnectionUrl() {
        System.out.println(">> Connecting to DB: " + dbProps.getDbDriver() + dbProps.getDbName());
    }
}