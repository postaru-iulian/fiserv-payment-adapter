package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentCardSaleTransactionResponse(
        String type,
        String clientRequestId,
        String apiTraceId,
        String ipgTransactionId,
        String orderId,
        PaymentToken paymentToken,
        String transactionType,
        String transactionOrigin,
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
        String schemeTransactionId,
        PaymentProcessor processor
) {
}