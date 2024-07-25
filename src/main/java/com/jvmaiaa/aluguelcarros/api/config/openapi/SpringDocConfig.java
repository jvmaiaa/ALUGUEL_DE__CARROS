package com.jvmaiaa.aluguelcarros.api.config.openapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api de Locação de carros")
                        .version("v1")
                        .description("Api que busca realizar a gestão de um locadora, tal como seus veículos, funcionários, clientes e pedidos.")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")
                        ))
                .externalDocs(new ExternalDocumentation()
                        .description("LinkedIn")
                        .url("https://www.linkedin.com/in/joão-víctor-maia-4b9961265/"))
                .tags(
                        Arrays.asList(
                                new Tag().name("Carro").description("Operações disponíveis para Carro."),
                                new Tag().name("Funcionário").description("Operações disponívei para Funcionário."),
                                new Tag().name("Endereço").description("Operações disponívei para Endereço."),
                                new Tag().name("Cliente").description("Operações disponívei para Cliente.")
                        )
                );
    }
}
