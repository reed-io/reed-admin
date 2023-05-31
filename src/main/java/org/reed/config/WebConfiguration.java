package org.reed.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "OPTIONS", "DELETE", "PUT", "HEAD", "FETCH")
                .allowedHeaders("Origin,X-Requested-With,Content-Type,Accept,Authorization,user_token,app_token,device_id,app_code,client_type,range")
                .allowedOrigins("*")
                .exposedHeaders("Content-Range")
                .maxAge(3600);
    }
}
