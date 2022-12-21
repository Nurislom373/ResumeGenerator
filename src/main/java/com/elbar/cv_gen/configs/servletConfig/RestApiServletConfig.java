package com.elbar.cv_gen.configs.servletConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/15/2022
 * <br/>
 * Time: 7:35 PM
 * <br/>
 * Package: com.elbar.cv_gen.configs.servletConfig
 */
@Configuration
@EnableWebMvc
public class RestApiServletConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
