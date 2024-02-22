package com.freecupon.MELI.domain.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {

    private static final String TITLE = "Challange: Cupón de Compra";
    private static final String DESCRIPTION = "Mercado Libre está implementando un nuevo beneficio " +
            "para los usuarios que más usan la plataforma con un cupón de cierto monto gratis " +
            "que les permitirá comprar tantos ítems marcados como favoritos sea posible, siempre que no " +
            "excedan el monto del cupón.";
    private static final String VERSION = "0.0.1-SNAPSHOT";

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI().info(new Info()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION));
    }

}
