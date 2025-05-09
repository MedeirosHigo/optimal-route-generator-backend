package com.example.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .addServersItem(new io.swagger.v3.oas.models.servers.Server()
            .url("/"))
            .info(new Info().title("Custom OpenAPI").version("1.0"));
    }
    @Bean
    public GroupedOpenApi customGroup() {
        return GroupedOpenApi.builder().group("public").pathsToMatch("/api/**").build();
    }
    
}
