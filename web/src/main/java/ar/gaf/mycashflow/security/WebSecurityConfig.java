package ar.gaf.mycashflow.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthEntryPoint authEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("gforrade").password("welcome1").roles("ADMIN","VIEWER","OTHER").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable()
                .httpBasic()
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(authEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler)
                .and()
                .formLogin()
                    .loginProcessingUrl("/security/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/security/logout")
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                .authorizeRequests()
                    .antMatchers("/login*").anonymous()
                    .anyRequest().authenticated();


        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/api/execution-plans/*/evaluate",
                        "/api/autorizador",
                        "/api/autorizador/*",
                        "/api/admin",
                        "/api/excecution-plans/*/evaluate")
                .permitAll()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/index.html", "/login.html", "/partials/**", "/", "/error/**");
    }

    @SuppressWarnings("rawtypes")
    public static class PreAuthorizationUserDetailsService implements AuthenticationUserDetailsService {

        private static final Logger logger = LoggerFactory.getLogger(PreAuthorizationUserDetailsService.class);

        @Override
        public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
            Objects.requireNonNull(token, "token cannot be null");
            Objects.requireNonNull(token.getPrincipal(), "token.getPrincipal() cannot be null");

            logger.info("token {}", token);
            User user;
            PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails tokenDetails = null;
            if(Objects.nonNull(token.getDetails()) &&
                    token.getDetails() instanceof PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails) {
                tokenDetails = (PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails) token.getDetails();

            }

            if(token.getPrincipal() instanceof User) {
                user = (User)token.getPrincipal();
            } else {
                user = new User(
                        (String) token.getPrincipal(),
                        "unused", true, true, true, true,
                        Objects.isNull(tokenDetails) ? token.getAuthorities() : tokenDetails.getGrantedAuthorities());
            }

            logger.info("user {}", user);
            return user;
        }
    }

    public static class SammLogoutHandler implements LogoutHandler {
        public void logout(HttpServletRequest request, HttpServletResponse response,
                           Authentication authentication) {
            Cookie[] cookiesToClear = request.getCookies();

            for (Cookie cookie : cookiesToClear) {

                Cookie newCookie = new Cookie(cookie.getName(), null);

                String cookiePath = request.getContextPath();
                if (!StringUtils.hasLength(cookiePath)) {
                    cookiePath = "/";
                }
                newCookie.setPath(cookiePath);
                newCookie.setMaxAge(0);

                response.addCookie(newCookie);
            }
        }

        public static LogoutHandler instance() {
            return new SammLogoutHandler();
        }
    }


}