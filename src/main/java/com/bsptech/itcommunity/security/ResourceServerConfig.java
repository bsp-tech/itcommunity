package com.bsptech.itcommunity.security;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId("restapi")
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

                http.authorizeRequests().anyRequest().permitAll();
//
//                  .and().authorizeRequests().antMatchers("/private").hasAnyAuthority("ADMIN", "CLIENT")
////                  .antMatchers(
////                                "/public/**",
////                                "/carUtilities/**",
////                                "/places/**",
////                                "/languages/**",
////                                "/nationalities/**",
////                                "/timeslots/**",
////                                "/cars/**",
////                                "/galleries/**",
////                                "/feedbacks/**",
////                                "/oauth/**"
////                                ).permitAll()
////                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/feedbacks").permitAll()
////                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/helps").permitAll()
////                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
//                .and().csrf().disable();

    }
}
