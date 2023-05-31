/**
 * E5Projects @ org.reed/ReedAdmin.java
 */
package org.reed;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.eventstore.InstanceEventStore;
import de.codecentric.boot.admin.server.services.InstanceIdGenerator;
import de.codecentric.boot.admin.server.services.InstanceRegistry;
import de.codecentric.boot.admin.server.web.InstancesController;
import org.reed.bootup.EnableAdminClient;
import org.reed.bootup.SpringBootBootup;
import org.reed.define.ReedGenerator;
import org.reed.define.ReedRegistry;
import org.reed.server.ReedAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import java.net.InetSocketAddress;

/**
 * @author chenxiwen
 * @createTime 2019年12月15日 下午4:46
 * @description
 */
// @EnableServiceRegister
@EnableAdminServer
@EnableAdminClient(server = "http://localhost:8080")
public class ReedAdmin extends SpringBootBootup {

    public static final Integer REED_ADMIN_SERVER_PORT = 33550;

    private ReedAdminServer reedAdminServer;

    @Override
    protected void beforeStart() { // reed
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b11538912870c81d60f421c582bd4a8d9d86ebdaf1eef4628d36499}",
                "ReedCipher{028c60107305bc40}");
        // putArgs("spring.boot.admin.client.username", "123");
        // putArgs("spring.boot.admin.client.password", "456");
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b11538912870c81d60f421c2d58fef4385eb5575ef3aa6d915f1e43}",
                "ReedCipher{2f8ab711c0397b48c7e8bab352a8977e}");
        // reed
        putArgs("ReedCipher{3e483352313a195ac58121f6e5fa5d761a029a6674477348af1eef4628d36499}",
                "ReedCipher{028c60107305bc40}");
        // putArgs("spring.security.user.name", "123");
        // putArgs("spring.security.user.password", "456");
        // password for login spring boot admin
        putArgs("ReedCipher{3e483352313a195ac58121f6e5fa5d7645d2438f1c827a8f4a5de61c6e276aa9}",
                "ReedCipher{2f8ab711c0397b48c7e8bab352a8977e}");
        // reed
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b11538912870c81d60f421c478aecd3c42e8ce477103e534d5cae3717ec21cad48553c50eefa52edcf87d63}",
                "ReedCipher{028c60107305bc40}");
        // this.putArgs("spring.boot.admin.client.instance.metadata.user.password", "456");
        // this.putArgs("spring.boot.admin.client.instance.metadata.user.name", "123");
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b11538912870c81d60f421c478aecd3c42e8ce477103e534d5cae3717ec21cad48553c58a65e0e80532b5fafeb959b7d4642fcb}",
                "ReedCipher{2f8ab711c0397b48c7e8bab352a8977e}");
        // this.putArgs("spring.boot.admin.ui.title", "Reed-Services-Admin");
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b115389c9627e2b18000c281cf3351861b8bf94}",
                "ReedCipher{fc65a6e91126870d36910b2f07320510ffe3bb80f35212e9}");
        this.putArgs("spring.boot.admin.ui.brand",
                "<img src=\"logo/LOGO.png\"><span>REED-SERVICE-ADMIN</span>");
        putArgs("ReedCipher{a3d3afefb0eafbbdb0c2789b8b1153896b77c7498373f3563a8f3b3cfdeb0112}",
                "ReedCipher{f12af4d66e32748383a955626fedb30a12479a018b516b57a0b41b45469e2cff97d9011f66269c5782c0e6fee7ae8e7ae8a392c2f882b696feb959b7d4642fcb}");

        // spring:
        // boot:
        // admin:
        // instance-auth:
        // enabled: true
        // default-user-name: root
        // default-password: root
        // putArgs("spring.boot.admin.instance-auth.enable", "true");
        // putArgs("spring.boot.admin.instance-auth.default-user-name", "123");
        // putArgs("spring.boot.admin.instance-auth.default-password", "456");
    }

    @Override
    protected void afterStart(SpringApplication application, ApplicationContext context) {
        reedAdminServer = context.getBean(ReedAdminServer.class);
        reedAdminServer.start(new InetSocketAddress(REED_ADMIN_SERVER_PORT));
    }

    /**
     * @return Project/Module Name
     */
    @Override
    public String getModuleName() {
        return "REED-ADMIN";
    }

    public static void main(String[] args) {
        new ReedAdmin().start(args);
    }


    @Configuration
    @Order(99)
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
        private final String adminContextPath;

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
            this.adminContextPath = adminServerProperties.getContextPath();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
            successHandler.setTargetUrlParameter("redirectTo");
            successHandler.setDefaultTargetUrl(adminContextPath + "/");

            http.authorizeRequests()
                    .antMatchers(adminContextPath + "/assets/**").permitAll()
                    .antMatchers(adminContextPath + "/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                    .logout().logoutUrl(adminContextPath + "/logout")
                    .and()
                    .httpBasic().and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .ignoringAntMatchers(
                            adminContextPath + "/instances",
                            adminContextPath + "/actuator/**"
                    );
            // @formatter:on
        }
    }

    @Bean
    // @ConditionalOnMissingBean
    public InstancesController instancesController(InstanceRegistry instanceRegistry,
            InstanceEventStore eventStore) {
        return new InstancesController(instanceRegistry, eventStore);
    }

    @Bean
    // @ConditionalOnMissingBean
    public InstanceRegistry instanceRegistry(InstanceRepository instanceRepository,
            InstanceIdGenerator instanceIdGenerator) {
        return new ReedRegistry(instanceRepository, instanceIdGenerator);
    }

    @Bean
    // @ConditionalOnMissingBean
    public InstanceIdGenerator instanceIdGenerator() {
        return new ReedGenerator();
    }
}
