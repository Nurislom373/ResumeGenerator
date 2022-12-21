package com.elbar.cv_gen;

import com.elbar.cv_gen.properties.OpenAPIProperties;
import com.elbar.cv_gen.properties.ServiceProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@OpenAPIDefinition
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({OpenAPIProperties.class, ServiceProperties.class})
public class CvGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(CvGenApplication.class, args);
    }
}
