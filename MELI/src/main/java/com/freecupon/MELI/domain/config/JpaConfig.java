package com.freecupon.MELI.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Value("${db.url}")
    private static String url;
    @Value("${db.username}")
    private static String username;
    @Value("${db.password}")
    private static String password;
    @Value("${db.driver.class}")
    private static String driverClassName;

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }

}
