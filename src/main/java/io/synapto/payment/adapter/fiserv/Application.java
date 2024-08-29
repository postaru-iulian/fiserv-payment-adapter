package io.synapto.payment.adapter.fiserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

import static java.util.TimeZone.getTimeZone;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(getTimeZone("UTC"));
        SpringApplication.run(Application.class, args);
    }
}
