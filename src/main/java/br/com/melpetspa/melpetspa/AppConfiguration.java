package br.com.melpetspa.melpetspa;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // ATENÇÃO: "*" permite qualquer origem. USE COM CAUTELA!
                        // Altamente NÃO RECOMENDADO para ambientes de produção.
                        // Para produção, liste explicitamente os domínios permitidos, ex:
                        // .allowedOrigins("http://seu-frontend.com", "https://seu-frontend.com")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}