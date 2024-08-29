package io.synapto.payment.adapter.fiserv.client;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class AuthorizationRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        getBearerTokenHeader().ifPresent(bearerToken ->
                template.header(AUTHORIZATION, bearerToken));
    }

    public static Optional<String> getBearerTokenHeader() {
        return Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .map(ServletRequestAttributes::getRequest)
                .map(request -> request.getHeader(AUTHORIZATION));
    }
}
