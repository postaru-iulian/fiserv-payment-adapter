package io.synapto.payment.adapter.fiserv.client.dto;

import java.time.Instant;

public record ApiKeyResponse(
        Boolean active,
        String apiAccessKey,
        Instant createdTime,
        String developerAppUuid,
        String merchantUuid,
        String tokenAssociationGroupUuid,
        Instant modifiedTime) {
}
