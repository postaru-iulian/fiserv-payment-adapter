package io.synapto.payment.adapter.fiserv.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDetailsRequest(
        String number,
        @JsonProperty("exp_month")
        String expMonth,
        @JsonProperty("exp_year")
        String expYear,
        String cvv,
        String brand) {
}
