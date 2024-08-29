package io.synapto.payment.adapter.fiserv.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import io.synapto.payment.adapter.fiserv.client.dto.ApiKeyResponse;
import io.synapto.payment.adapter.fiserv.client.dto.ChargeRequest;
import io.synapto.payment.adapter.fiserv.client.dto.ChargeResponse;

@FeignClient(name = "ecommerce-service")
public interface EcommerceServiceClient {

    @GetMapping(path = "/pakms/apikey", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiKeyResponse retrieveApiKey();

    @GetMapping(path = "/v1/charges", produces = MediaType.APPLICATION_JSON_VALUE)
    ChargeResponse charge(ChargeRequest chargeRequest,
            @RequestHeader("x-forwarded-for") String xForwardedFor,
            @RequestHeader("idempotency-key") String idempotencyKey);
}
