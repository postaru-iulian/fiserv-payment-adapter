package io.synapto.payment.adapter.fiserv.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenRequest;
import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenResponse;

@FeignClient(name = "card-tokenization-service")
public interface CardTokenizationServiceClient {

    @PostMapping(path = "/v1/tokens", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    CreateCardTokenResponse createCardToken(
            @RequestBody CreateCardTokenRequest createCardTokenRequest,
            @RequestHeader("apikey") String apikey);

}
