//package org.reed.config;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//
////@Component
//public class CorsFilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest request, HttpServletResponse response,
//            FilterChain chain) throws IOException, ServletException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT,HEAD");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Expose-Headers", "Content-Range");
//        response.setHeader("Access-Control-Allow-Headers",
//                "Origin,X-Requested-With,Content-Type,Accept,Authorization,user_token,app_token,device_id,app_code,client_type,range");
//        // response.setHeader("Access-Control-Allow-Headers", "*");
//        chain.doFilter(request, response);
//    }
//
//}
