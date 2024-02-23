package com.freecupon.MELI.domain.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    private static String url = "jdbc:postgresql://meli-db.c72g60oq8sff.us-east-2.rds.amazonaws.com:5432/meli";
    private static String username = "postgres"; // Poner su usuario
    private static String password = "cocoliso"; // colocar su contraseña

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("org.postgresql.Driver")
                .build();
    }

}
