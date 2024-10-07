package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentCardSaleTransaction(
        String requestType,
        TransactionAmount transactionAmount,
        String merchantTransactionId,
        PaymentMethod paymentMethod
) {
}
