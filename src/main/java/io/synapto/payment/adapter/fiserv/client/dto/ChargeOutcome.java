package io.synapto.payment.adapter.fiserv.client.dto;

public record ChargeOutcome(
        String network_status,
        String type) {
}
