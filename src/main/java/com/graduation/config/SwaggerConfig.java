package com.graduation.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Restaurant Voting App",
                version = "1.0",
                description = "Restaurant Voting REST API using Spring-Boot",
                contact = @io.swagger.v3.oas.annotations.info.Contact(url = "https://azatick94.github.io/personal_page/",
                        name = "Azat Burkhanov", email = "azburhanov@mail.ru")
        ),
        security = @SecurityRequirement(name = "basicAuth"))
@Slf4j
public class SwaggerConfig {
}
