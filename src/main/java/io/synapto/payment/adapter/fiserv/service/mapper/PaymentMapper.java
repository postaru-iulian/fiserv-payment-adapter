package io.synapto.payment.adapter.fiserv.service.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.synapto.payment.adapter.fiserv.client.dto.ChargeResponse;
import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenRequest;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCard;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationRequest;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardPaymentTokenizationResponse;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransaction;
import io.synapto.payment.adapter.fiserv.client.dto.PaymentCardSaleTransactionResponse;
import io.synapto.payment.adapter.fiserv.dto.CardRequest;
import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenRequest;
import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenResponse;
import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionRequest;
import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionResponse;
import io.synapto.payment.adapter.fiserv.dto.PaymentRequest;
import io.synapto.payment.adapter.fiserv.dto.PaymentResponse;

@Mapper(componentModel = SPRING)
public interface PaymentMapper {

    CreateCardTokenRequest toCardDetailsRequest(PaymentRequest cardRequest);

    PaymentResponse toPaymentResponse(ChargeResponse chargeResponse);

    @Mapping(target = "requestType", constant = "PaymentCardSaleTransaction")
    @Mapping(target = "transactionAmount.total", source = "amount")
    @Mapping(target = "transactionAmount.currency", source = "currency")
    @Mapping(target = "paymentMethod.paymentCard", source = "card")
    PaymentCardSaleTransaction toPaymentCardSaleTransaction(GeneratePrimaryTransactionRequest request);

    GeneratePrimaryTransactionResponse toGeneratePrimaryTransactionResponse(PaymentCardSaleTransactionResponse response);

    @Mapping(target = "requestType", constant = "PaymentCardPaymentTokenizationRequest")
    @Mapping(target = "paymentCard", source = "card")
    @Mapping(target = "createToken.reusable", source = "reusable")
    @Mapping(target = "createToken.declineDuplicates", source = "declineDuplicates")
    PaymentCardPaymentTokenizationRequest toPaymentCardPaymentTokenizationRequest(CreatePaymentTokenRequest request);

    @Mapping(target = "securityCode", source = "cvv")
    @Mapping(target = "expiryDate.month", source = "expMonth")
    @Mapping(target = "expiryDate.year", source = "expYear")
    PaymentCard toPaymentCard(CardRequest cardRequest);

    CreatePaymentTokenResponse toCreatePaymentTokenResponse(PaymentCardPaymentTokenizationResponse response);
}