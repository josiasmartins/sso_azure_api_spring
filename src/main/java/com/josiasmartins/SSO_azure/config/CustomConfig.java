package com.josiasmartins.SSO_azure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class CustomConfig {

//    @Bean
//    public WebSecurity configure(WebSecurity web) throws Exception {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        //configure the firewall instance....
//        return web.httpFirewall(firewall);
//    }

    @Bean
    public HttpFirewall allowUrlEncodedPercentHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowUrlEncodedDoubleSlash(true);
//        firewall.setAllowSemicolon(true);

        return firewall;
    }

}