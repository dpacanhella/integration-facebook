package io.redspark;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import com.google.common.base.Predicate;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())    
                .build()
            .pathMapping("/")
            .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "ProjetoInterno Diego Pacanhella",
            "Pacanhella.",
            "1.0.0",
            "redspark.io",
            "API License",
            "API License URL",
            "/"
        );
        
        return apiInfo;
    }
    
    @SuppressWarnings("unchecked")
    private Predicate<String> paths() {
        return or(regex("/facebook.*")
                );
    }
}
