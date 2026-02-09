package com.boutique.usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Configuración de OpenAPI para msv-usuario.
 * Define la información de la API y el esquema de autenticación Bearer JWT.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("MSV Usuario API")
                .version("1.0.0")
                .description("Microservicio de Gestión de Usuarios - Boutique")
                .contact(new Contact()
                    .name("Equipo de desarrollo Boutique")
                    .email("support@boutique.com")
                )
            )
            .addSecurityItem(new SecurityRequirement().addList("Bearer JWT"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("Bearer JWT", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("Ingrese el token JWT obtenido del Authorization Server")
                )
            );
    }
}
