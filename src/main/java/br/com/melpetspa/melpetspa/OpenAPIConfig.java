package br.com.autosafe;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    // Este bean é para as informações gerais da API (título, descrição, etc.)
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AutoSafe API")
                        .description("Documentação oficial da AutoSafe - Plataforma de serviços automotivos")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipe AutoSafe")
                                .email("contato@autosafe.com.br")
                                .url("https://www.autosafe.com.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório no GitHub")
                        .url("https://github.com/autosafe/backend"));
    }

    // NOVO BEAN: Este bean é responsável por definir quais pacotes e caminhos serão escaneados
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("autosafe-api") // Um nome para este grupo de APIs (opcional)
                .pathsToMatch("/**") // Inclui todos os caminhos (endpoints)
                .packagesToScan("br.com.autosafe.controller") // <--- ESTA É A LINHA CRÍTICA!
                .build();
    }
}