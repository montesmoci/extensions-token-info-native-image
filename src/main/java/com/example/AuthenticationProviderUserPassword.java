package com.example;

import io.micronaut.context.env.Environment;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.util.Collections;
import java.util.List;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    private final Environment environment;

    public AuthenticationProviderUserPassword(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {

        String identity = (String) authenticationRequest.getIdentity();
        String password = (String) authenticationRequest.getSecret();

        if ( (identity.equals("user") || identity.equals("admin")) && password.equals("password") ) {

            String email = "user@example.com";
            if (identity.equals("admin") ){
                email = "admin@example.com";
            }

            return Publishers.just(AuthenticationResponse.success( email,
                    (identity.equals("admin") ? List.of("ADMIN") : Collections.emptyList())
            ));
        }

        return Publishers.just(AuthenticationResponse.failure());
    }
}
