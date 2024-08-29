package io.synapto.payment.adapter.fiserv.dto;

public record CardRequest(
        String number,
        String expMonth,
        String expYear,
        String cvv,
        String brand) {
}
