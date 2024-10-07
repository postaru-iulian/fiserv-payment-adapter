package io.synapto.payment.adapter.fiserv.client;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.synapto.payment.adapter.fiserv.config.ApiCredentials;
import io.synapto.payment.adapter.fiserv.config.FiservCredentialsProvider;
import io.synapto.payment.adapter.fiserv.util.FiservMessageSigner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FiservPaymentRequestInterceptor implements RequestInterceptor {

    private static final String API_KEY = "Api-Key";

    private static final String CLIENT_REQUEST_ID = "Client-Request-Id";

    private static final String TIMESTAMP = "Timestamp";

    private static final String MESSAGE_SIGNATURE = "Message-Signature";

    private final FiservCredentialsProvider credentialsProvider;

    @Override
    public void apply(RequestTemplate template) {
        final String clientRequestId = getClientRequestId().orElse(UUID.randomUUID().toString());
        final ApiCredentials apiCredentials = credentialsProvider.getApiCredentials();
        final String timestamp = Long.toString(Instant.now().toEpochMilli());
        final String content = getContent(template);

        final String message = apiCredentials.apiKey() + clientRequestId + timestamp + content;
        final String messageSignature = FiservMessageSigner.generateSignature(apiCredentials.secretKey(), message);

        template.header(API_KEY, apiCredentials.apiKey());
        template.header(CLIENT_REQUEST_ID, clientRequestId);
        template.header(TIMESTAMP, timestamp);
        template.header(MESSAGE_SIGNATURE, messageSignature);
    }

    private String getContent(RequestTemplate template) {
        return Request.HttpMethod.GET.name().equals(template.method()) ?
                EMPTY : new String(template.body(), StandardCharsets.UTF_8);
    }

    private Optional<String> getClientRequestId() {
        return Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .map(ServletRequestAttributes::getRequest)
                .map(request -> request.getHeader(CLIENT_REQUEST_ID));
    }

}
