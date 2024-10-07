package io.synapto.payment.adapter.fiserv.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FiservCredentialsProvider {

    private final Environment environment;

    public ApiCredentials getApiCredentials() {
        return new ApiCredentials(
                environment.getRequiredProperty("application.credentials.api-key"),
                environment.getRequiredProperty("application.credentials.secret-key")
        );
    }

}