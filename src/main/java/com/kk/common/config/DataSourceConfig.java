//package com.kk.common.config;
//
//import com.amazonaws.xray.AWSXRay;
//import com.amazonaws.xray.AWSXRayRecorderBuilder;
//import com.amazonaws.xray.sql.TracingDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource(DataSourceProperties properties) {
//        DataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//        return TracingDataSource.decorate(dataSource);
//    }
//}
