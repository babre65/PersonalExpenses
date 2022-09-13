package com.reihaneh.personalexpenses.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(getCustomInfo());
    }

    private Info getCustomInfo() {
        return new Info()
                .title("Personal Expenses")
                .version("1.0")
                .description("This is an application for managing the daily expenses.");
    }
}
