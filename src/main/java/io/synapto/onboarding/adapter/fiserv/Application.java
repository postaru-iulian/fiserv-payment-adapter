package io.synapto.onboarding.adapter.fiserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

import static java.util.TimeZone.getTimeZone;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(getTimeZone("UTC"));
        SpringApplication.run(Application.class, args);
    }
}
