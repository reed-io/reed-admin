package org.reed.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.reed.interceptor.EnableInterceptor;
import org.reed.interceptor.ReedInterceptor;

/**
 * OptionRequestHandler仅用于将options请求http status转换为200 解决增加auth之后，options请求返回401的问题
 */
@EnableInterceptor(order = 101)
public class OptionRequestHandler implements ReedInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT,HEAD");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Expose-Headers", "Content-Range");
//        response.setHeader("Access-Control-Allow-Headers",
//                "Origin,X-Requested-With,Content-Type,Accept,Authorization,user_token,app_token,device_id,app_code,client_type,range");
        // response.setHeader("Access-Control-Allow-Headers", "*");
        return ReedInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public String[] pathPatterns() {
        return new String[] {"/**"};
    }
}
