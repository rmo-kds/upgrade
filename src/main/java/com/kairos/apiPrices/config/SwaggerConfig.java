package com.kairos.apiPrices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.kairos.apiPrices.controller"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
        return new ApiInfo(
                "Kairos : Spring Boot REST API Zara Prices",
                "Spring Boot REST API for Prices queries",
                "1.0",
                "Terms of service",
                new Contact("Rubén Martín Olmedo", "https://www.kairosds.com/", "ruben.martin@kairosds.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }

}
