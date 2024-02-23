package com.freecupon.MELI.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ModelMapper {
    @Bean(name = "ModelMapper")
    public org.modelmapper.ModelMapper modelMapper(){
            return new org.modelmapper.ModelMapper();
        }

}
