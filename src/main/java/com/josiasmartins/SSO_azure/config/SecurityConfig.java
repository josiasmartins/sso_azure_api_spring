package com.josiasmartins.SSO_azure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorized -> authorized
                                        .requestMatchers("/user/**").permitAll()
                                        .anyRequest().authenticated()
                        )
                .oauth2ResourceServer((server) ->
                        server.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        System.out.println("CHAMEI O FILTER HTTP: " + http);

        return http.build();
    }

    // Caso precise customizar a conversão de JWT para Authorities
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        // Adicione uma conversão personalizada aqui, se necessário
//        var jwt = new Jwt(
//                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Inp4ZWcyV09OcFRrd041R21lWWN1VGR0QzZKMCJ9.eyJhdWQiOiI0MjVjYWUxOS1hNTY4LTQwN2MtYTI1Zi05MWY3ZmIyNDMwNzAiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vOWQ2NGRmYWItNjQ0ZC00ZWU1LTk2MjAtOTM0YjUyZjQ4YWI1L3YyLjAiLCJpYXQiOjE3MzQxMTYyODcsIm5iZiI6MTczNDExNjI4NywiZXhwIjoxNzM0MTIwMTg3LCJhaW8iOiJBZlFBQy84WUFBQUEwMHVHOGkxT2hoZDZFRjhBb01YNmowMkIxV1NnZjhzUEVYSFl0MEZzVEZOeW1HampRNWFxTVdzdmNScDJSckFZTW5QMnZscnZTWkZkdysvVUwrY0RjTy80Q3hwa3U3UXhDaWVQUW5ZNTRQSW1nTVVJb0YvazlZUU9IR0trSmlyQ0RMMEwzV2tKdkpHdDBIdE1sZERSc1I1YzFkL1c3azU3QTBDY0pCbUV3cDJnRDJidkJ1aGNLUjdWbnhxeFhHcHBXK2Mzakhidkh3aWpHTjFSRWRmem51R3UxQ25SQlZBdUs3YnJRTDNzRTBha2R0ZFJ4OE1FL0dOa2VHQUt4a0ltanVDQXRCenVjQ2NjeXNRVU1BVHBPeDVBd3BJc1d5RVdiditWeGpSTTJma2IxVUhwYTRuSXVzRDdFUWtyeFFveCIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2UwNzkzZDM5LTA5MzktNDk2ZC1iMTI5LTE5OGVkZDkxNmZlYi8iLCJuYW1lIjoiQ2FpdGFubywgSm9zaWFzIE1hcnRpbnMiLCJub25jZSI6IjAxOTNjMTY3LTI5N2YtNzE4Ny05MmEyLTE0NjYzYjMwNTMzNyIsIm9pZCI6IjZlNzA4ZGJhLWM1NzgtNGY5NS1iOGVmLWE3YWEyNTcxYzQ5NSIsInByZWZlcnJlZF91c2VybmFtZSI6Impvc2lhcy5tLmNhaXRhbm9AYWNjZW50dXJlLmNvbSIsInJoIjoiMS5BVFFBcTk5a25VMWs1VTZXSUpOTFV2U0t0Um11WEVKb3BYeEFvbC1SOV9za01IQTBBSmcwQUEuIiwic3ViIjoibFhxbE56YnBmZlRjeUFfM1pKeGVmN0NWdEk2NTlqYVBWM0ttTVdHMURZVSIsInRpZCI6IjlkNjRkZmFiLTY0NGQtNGVlNS05NjIwLTkzNGI1MmY0OGFiNSIsInV0aSI6ImdueFVJUkU2TlU2NFFjalJEaXhZQUEiLCJ2ZXIiOiIyLjAifQ.bPXqdN7TOSmmgpNPBfz8ouZMtK9Oftdwv0OWJebMejyBTateTMb8rn2o80cNmufEYExaCRFdgiXPyy1xAlftrKpwriMCCsLHUhQjOqweAqmGJkc2SWYo7ZSslaG4fy0GxcigIrbpfjheiVP9R13sNfTuHOJQs7nKRnQDj9zdjdfBHN0U-_iZwrP98YepiKd4T1mV9lsytrKmYGEDKaP8D6QKaJaxLquHNApGMaZpKqlVeLqG3IWIgWF223A-n73XWlZkwUhDajYi75GMJUiZkR89DjHVsIRob4CJ4CGVKzcrPcFCoVMZXC7L7abNtmCHRPGul-7zACIGCzyxG6I3mA",
//                null,
//                null,
//                null,
//                null);

//        System.out.println(jwt)

//        converter.convert("https://login.microsoftonline.com/9d64dfab-644d-4ee5-9620-934b52f48ab5/discovery/v2.0/keys")
        return converter;
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(
                        "https://login.microsoftonline.com/9d64dfab-644d-4ee5-9620-934b52f48ab5/discovery/v2.0/keys")
                .build();

        return jwtDecoder;
    }


}

