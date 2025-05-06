package com.mehul.e.commerce.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${mehul.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("mehulverma@gmail.com");
        contact.setName("Mehul Verma");
        contact.setUrl("https://mehul-verma.vercel.app/");

        License mitLicense = new License().name("Dummy License").url("https://www.w3.org/Provider/Style/dummy.html");

        Info info = new Info()
                .title("Products REST API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage products in an e-commerce WEBSITE.").termsOfService("https://www.w3.org/Provider/Style/dummy.html")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}