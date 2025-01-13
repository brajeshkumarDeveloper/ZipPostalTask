package com.tcs.zip.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
//    @Bean
//    public Docket api() {
//      return new Docket(DocumentationType.SWAGGER_2)
//      .select()
//      .apis(RequestHandlerSelectors.any())
//      .paths(PathSelectors.any()).build();
//    }
}
