package fr.dawid.cap_poec_java.configuration;

import fr.dawid.cap_poec_java.mapping.UrlRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/").authenticated()
                                .requestMatchers(UrlRoute.URL_GAMES + "/**").authenticated()
                                .requestMatchers(UrlRoute.URL_REVIEWS + "/**").hasRole("MODERATOR")
                                .requestMatchers(HttpMethod.POST, UrlRoute.URL_GAMES + "/**").hasRole("MODERATOR")
                                .requestMatchers("/admin/**").hasAuthority("ROLE_MODERATOR")
                                .requestMatchers("/**").permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage(UrlRoute.URL_LOGIN)
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login")
                                .permitAll()
                );

        return http.build();
    }

}