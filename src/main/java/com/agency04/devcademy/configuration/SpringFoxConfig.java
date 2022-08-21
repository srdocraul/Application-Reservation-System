package com.agency04.devcademy.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringFoxConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("raul.srdoc6@gmail.com");
        contact.setName("Raul");
        contact.setUrl("https://www.accommodationreservation.com");

        return new OpenAPI()
                .info(new Info().title("Accommodation Reservation System")
                        .description("On ARS, you'll find vacation rentals, beach houses, unique accommodations, " +
                                "and experiences around the world, all made possible by hosts.")
                        .version("v0.0.1")
                        .termsOfService("https://www.accommodationreservation.com/tos")
                        .contact(contact)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("More about SpringDoc and OpenAPI 3")
                        .url("https://springdoc.org/"));
    }
}
