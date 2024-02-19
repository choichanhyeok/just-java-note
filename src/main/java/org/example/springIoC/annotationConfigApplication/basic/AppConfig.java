package org.example.springIoC.annotationConfigApplication.basic;

import org.example.springIoC.annotationConfigApplication.basic.service.AcTestOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AcTestOrderService testOrderService() {
        return new AcTestOrderService();
    }

}
