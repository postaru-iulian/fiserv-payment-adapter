package io.synapto.payment.adapter.fiserv.service.mapper;

import org.mapstruct.Mapper;

import io.synapto.payment.adapter.fiserv.client.dto.ChargeResponse;
import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenRequest;
import io.synapto.payment.adapter.fiserv.dto.PaymentRequest;
import io.synapto.payment.adapter.fiserv.dto.PaymentResponse;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    CreateCardTokenRequest toCardDetailsRequest(PaymentRequest cardRequest);

    PaymentResponse toPaymentResponse(ChargeResponse chargeResponse);
}