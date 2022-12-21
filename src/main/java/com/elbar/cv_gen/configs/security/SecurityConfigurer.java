package com.elbar.cv_gen.configs.security;

import com.elbar.cv_gen.configs.filter.CustomAuthenticationFilter;
import com.elbar.cv_gen.configs.filter.CustomAuthorizationFilter;
import com.elbar.cv_gen.repository.auth.auth_user.AuthUserRepository;
import com.elbar.cv_gen.service.auth.auth_token.AuthTokenService;
import com.elbar.cv_gen.utils.BaseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfigurer {

    private final PasswordEncoder encoderConfigurer;
    private final UserDetailsService userDetailsService;
    private final AuthTokenService tokenService;
    private final AuthUserRepository userRepository;

    public static final String[] WHITE_LIST = {
            "/swagger-ui/**",
            "/api/v1/template/**",
            "/swagger-documentation/**",
            BaseUtils.PATH + "/auth_user/login",
            BaseUtils.PATH + "/auth_user/create"
    };

    @Bean
    public AuthenticationManager authManager() {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoderConfigurer);
        return new ProviderManager(authProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors().disable()
                .authorizeRequests(auth -> auth
                        .mvcMatchers(WHITE_LIST).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(new CustomAuthenticationFilter(authManager(), tokenService, userRepository))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
