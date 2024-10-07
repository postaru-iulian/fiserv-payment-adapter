package io.synapto.payment.adapter.fiserv.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FiservMessageSigner {

    private static final String HMAC_SHA_256 = "HmacSHA256";

    public static String generateSignature(String secret, String message) {
        try {
            final Mac hMac256 = Mac.getInstance(HMAC_SHA_256);
            final SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA_256);
            hMac256.init(secretKeySpec);
            final byte[] signature = hMac256.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Exception occurred while creating message signature: ", e);
            throw new RuntimeException(e);
        }
    }
}
