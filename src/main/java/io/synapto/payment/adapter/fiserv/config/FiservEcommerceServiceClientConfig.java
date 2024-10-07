package io.synapto.payment.adapter.fiserv.config;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;
import io.synapto.payment.adapter.fiserv.client.FiservPaymentRequestInterceptor;

public class FiservEcommerceServiceClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor(FiservCredentialsProvider credentialsProvider) {
        return new FiservPaymentRequestInterceptor(credentialsProvider);
    }

}
