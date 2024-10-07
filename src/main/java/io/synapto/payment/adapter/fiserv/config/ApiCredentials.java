package io.synapto.payment.adapter.fiserv.config;

public record ApiCredentials(
        String apiKey,
        String secretKey
) {
}