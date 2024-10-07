package io.synapto.payment.adapter.fiserv.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationRequest;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationResponse;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransaction;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransactionResponse;
import io.synapto.payment.adapter.fiserv.config.FiservEcommerceServiceClientConfig;

@FeignClient(name = "fiserv-ecommerce-service", configuration = FiservEcommerceServiceClientConfig.class)
public interface FiservEcommerceServiceClient {

    @PostMapping(path = "/ipp/payments-gateway/v2/payments", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    PaymentCardSaleTransactionResponse createPaymentCardSaleTransaction(PaymentCardSaleTransaction paymentCardSaleTransaction);

    @PostMapping(path = "/ipp/payments-gateway/v2/payment-tokens", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    PaymentCardPaymentTokenizationResponse createPaymentToken(PaymentCardPaymentTokenizationRequest paymentCardPaymentTokenizationRequest);

}
