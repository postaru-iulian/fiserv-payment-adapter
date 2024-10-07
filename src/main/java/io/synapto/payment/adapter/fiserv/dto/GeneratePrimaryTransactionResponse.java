package io.synapto.payment.adapter.fiserv.dto;

import io.synapto.payment.adapter.fiserv.client.dto.PaymentMethodDetails;
import io.synapto.payment.adapter.fiserv.client.dto.TransactionAmount;

public record GeneratePrimaryTransactionResponse(
        String clientRequestId,
        String apiTraceId,
        String ipgTransactionId,
        String orderId,
        PaymentMethodDetails paymentMethodDetails,
        String country,
        String terminalId,
        String merchantId,
        String merchantTransactionId,
        Integer transactionTime,
        TransactionAmount approvedAmount,
        TransactionAmount transactionAmount,
        String transactionStatus,
        String approvalCode,
        String schemeTransactionId
) {
}

