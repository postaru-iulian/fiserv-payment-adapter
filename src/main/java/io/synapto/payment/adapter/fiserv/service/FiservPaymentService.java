package io.synapto.payment.adapter.fiserv.service;

import org.springframework.stereotype.Service;

import io.synapto.payment.adapter.fiserv.client.FiservEcommerceServiceClient;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationRequest;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationResponse;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransaction;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransactionResponse;
import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenRequest;
import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenResponse;
import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionRequest;
import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionResponse;
import io.synapto.payment.adapter.fiserv.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FiservPaymentService {

    private final FiservEcommerceServiceClient fiservEcommerceServiceClient;

    private final PaymentMapper paymentMapper;

    public GeneratePrimaryTransactionResponse generatePrimaryTransaction(GeneratePrimaryTransactionRequest request) {
        PaymentCardSaleTransaction paymentCardSaleTransaction = paymentMapper.toPaymentCardSaleTransaction(request);

        PaymentCardSaleTransactionResponse response = fiservEcommerceServiceClient.createPaymentCardSaleTransaction(
                paymentCardSaleTransaction);

        return paymentMapper.toGeneratePrimaryTransactionResponse(response);
    }

    public CreatePaymentTokenResponse createPaymentToken(CreatePaymentTokenRequest request) {
        PaymentCardPaymentTokenizationRequest paymentCardPaymentTokenizationRequest =
                paymentMapper.toPaymentCardPaymentTokenizationRequest(request);

        PaymentCardPaymentTokenizationResponse response = fiservEcommerceServiceClient.createPaymentToken(
                paymentCardPaymentTokenizationRequest);

        return paymentMapper.toCreatePaymentTokenResponse(response);
    }
}
