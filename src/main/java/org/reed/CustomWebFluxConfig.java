///**
// * E5Projects#org.reed/CustomWebFluxConfig.java
// */
//package org.reed;
//
//import org.reed.define.Order;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.reactive.config.CorsRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
///**
// * @author chenxiwen
// * @date 2021-02-02 10:51:48
// */
////@Configuration
//public class CustomWebFluxConfig implements WebFluxConfigurer {
//
//    /**
//     * 全局跨域配置，根据各自需求定义
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("*");
////                .exposedHeaders(HttpHeaders.SET_COOKIE);
//    }
//
//    /**
//     * 也可以继承CorsWebFilter使用@Component注解，效果是一样的
//     * @return
//     */
//    @Bean
//    @Order(-200)
//    CorsWebFilter corsWebFilter(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.addAllowedOrigin("*");
////        corsConfiguration.addExposedHeader(HttpHeaders.SET_COOKIE);
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
////        ((UrlBasedCorsConfigurationSource) corsConfigurationSource).registerCorsConfiguration("/**",corsConfiguration);
//        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        System.err.println("11111"+corsConfigurationSource);
//        return new CorsWebFilter(corsConfigurationSource);
//    }
//}
