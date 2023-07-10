package com.dh.ReservaConsulta.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Odontológica ")
                        .version("1.0")
                        .description("Descrição da API")
                        .contact(new Contact()
                                .name("Carlos Roberto Landerdahl Neto")
                                .email("carloslanderdahl27@gmail.com")));
    }
}
