package com.taim.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {
        "com.taim.taimbackendservicejavaclient.client",
        "com.taim.taimbackendservicejavaclient.configuration",
        "com.taim.taimbackendservice.configuration",
        "com.taim.content"},
        exclude={DataSourceAutoConfiguration.class})
public class TaimFrontendContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaimFrontendContentApplication.class, args);
    }
}
