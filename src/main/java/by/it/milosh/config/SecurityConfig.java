package by.it.milosh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationService authService;


//    @Bean
//    public TokenBasedRememberMeServices rememberMeServices() {
//        return new TokenBasedRememberMeServices("remember-me-key", authService);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/", "/setup", "/main/**", "/resources/**", "/?lang=en_US", "/?lang=ru_RU").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/main/login")
                    .defaultSuccessUrl("/main/setUserToSession")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout").permitAll()
                    .logoutSuccessUrl("/").permitAll()
                    .and()
//                .rememberMe()
//                    .rememberMeServices(rememberMeServices())
//                    .key("remember-me-key")
//                    .rememberMeParameter("remember-me-param")
//                    //.rememberMeCookieName("my-remember-me")
//                    .tokenValiditySeconds(86400)
//                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authService)
                .passwordEncoder(passwordEncoder())
        ;
    }

}
