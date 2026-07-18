package com.tomcat.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity.authorizeExchange(exchange->
                        exchange.pathMatchers(HttpMethod.GET).permitAll()
                                .pathMatchers("/eazybank/accounts/**").hasRole("ACCOUNTS")
                                .pathMatchers("/eazybank/cards/**").hasRole("CARDS")
                                .pathMatchers("/eazybank/loans/**").hasRole("LOANS")
                                                            .anyExchange().authenticated())
                .oauth2ResourceServer(oAuth2ResourceServerSpec ->
                        oAuth2ResourceServerSpec
                                .jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(
                                        new ReactiveJwtAuthenticationConverterAdapter(new KeycloakRoleConverter())
                                )));
        serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return serverHttpSecurity.build();
    }
}
