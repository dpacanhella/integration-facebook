package io.redspark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ExampleSpringIntergrationFacebook {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringIntergrationFacebook.class, args);
    }
    
    @Bean
    public SwaggerConfig swagger() {
        return new SwaggerConfig();
    }

}