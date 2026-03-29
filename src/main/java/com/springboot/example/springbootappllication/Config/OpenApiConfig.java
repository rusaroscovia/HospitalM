package com.springboot.example.springbootappllication.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Hospital API")
                        .version("1.0.0")
                        .description("Hospital management API with Patient, Doctor and Appointment services"));
    }
}
