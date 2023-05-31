package org.reed;


import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;
import org.reed.utils.Base64Util;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class ReedAdminHttpHeaderProvider {
    @Bean
    public HttpHeadersProvider customHttpHeadersProvider() {
        return  instance -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            String authorization = "Basic " + Base64Util.encode("reed:Eui2560@%^)".getBytes(StandardCharsets.UTF_8));
//            httpHeaders.add("Authorization", "Basic cmljaGZpdDpFdWkyNTYwQCVeKQ==");
            httpHeaders.add("Authorization", authorization);
            return httpHeaders;
        };
    }



}