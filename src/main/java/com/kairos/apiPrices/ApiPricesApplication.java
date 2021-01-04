package com.kairos.apiPrices;

import com.kairos.apiPrices.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ApiPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPricesApplication.class, args);
	}

}
