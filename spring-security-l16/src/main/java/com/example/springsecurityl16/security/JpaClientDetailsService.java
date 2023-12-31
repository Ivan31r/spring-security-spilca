package com.example.springsecurityl16.security;

import com.example.springsecurityl16.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

@Component
public class JpaClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return new SecurityClient(clientRepository.findClientByClientId(clientId).
                orElseThrow(() -> new ClientRegistrationException("Client not found")));
    }
}
