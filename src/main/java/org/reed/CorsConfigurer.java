///**
// * E5Projects#org.reed/CrosConfigurer.java
// */
//package org.reed;
//
//import org.springframework.web.reactive.config.CorsRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
///**
// * @author chenxiwen
// * @date 2021-02-02 10:34:45
// */
//@Configuration
//public class CorsConfigurer implements WebFluxConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry){
//        corsRegistry.addMapping("*/**").allowedOrigins("*")
//                .allowedMethods("POST","GET","PUT","DELETE","OPTIONS","HEAD")
//                .allowCredentials(true)
//                .allowedHeaders("*")
//                .maxAge(3600);
//    }
//}
