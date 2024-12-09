//package com.josiasmartins.SSO_azure;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.firewall.DefaultHttpFirewall;
//import org.springframework.security.web.firewall.HttpFirewall;
//
//@Configuration
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(authorize -> authorize
////                        .anyRequest().permitAll()
////                );
////        return http.build();
////    }
//
////    @Bean
////    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
////        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
////        firewall.setAllowUrlEncodedSlash(true); // Permite barras codificadas
//////        firewall.setAllowUrlEncodedDoubleSlash(true); // Permite barras duplas codificadas
////        return firewall;
////    }
//
//    @Bean
//    public HttpFirewall defaultHttpFirewall() {
//        return new DefaultHttpFirewall();
//    }
//
//}
