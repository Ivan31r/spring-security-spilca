package com.example.springsecurityl22.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();

        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
       return new InMemoryClientRegistrationRepository(gitHubRegistration());
    }

    private ClientRegistration gitHubRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("client-id-from-github")
                .clientSecret("client-secret-from-github")
                .build();
    }
}
