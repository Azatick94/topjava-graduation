package com.graduation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-name}") String appName,
                                 @Value("${application-description}") String appDescription,
                                 @Value("${application-version}") String appVersion
    ) {

        return new OpenAPI()
                .info(new Info()
                        .title(appName)
                        .version(appVersion)
                        .description(appDescription)
                        .contact(new Contact()
                                .email("azburhanov@mail.ru")
                                .name("Azat Burkhanov")
                                .url("https://azatick94.github.io/personal_page/")));
    }
}
