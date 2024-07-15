package com.pragma.microservicetraceabilityfoodcourt.configuration.security;

import com.pragma.microservicetraceabilityfoodcourt.configuration.security.filter.JwtAuthenticationFilter;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.POST, "/traceability/").hasAnyAuthority(Role.CUSTOMER.name())
                .antMatchers(HttpMethod.GET, "/traceability/{orderId}").hasAnyAuthority(Role.EMPLOYEE.name(), Role.CUSTOMER.name())
                .antMatchers(HttpMethod.GET, "/traceability/").hasAnyAuthority(Role.EMPLOYEE.name(), Role.CUSTOMER.name())
                .antMatchers(HttpMethod.PATCH, "/traceability/{orderId}").hasAnyAuthority(Role.EMPLOYEE.name())
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
