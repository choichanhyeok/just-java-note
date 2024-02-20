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

    /**
     * 스프링 부트의 경우 이 과정을 컴포넌트 스캔이란 것들을 통해 대신하는데, 의존성 관리 대상인 Bean들을 @Component라는 애노테이션을 마킹해 스프링 부트가 뜰 때 컴포넌트 스캔을 통해 등록함.
     * 그런게 아니라면 이렇게 하나하나 손으로 등록 해줘야함, 컴포넌트 스캔 없으면 사실 그냥 겁나 불편한 건데
     *
     * 이렇게 등록한 bean은 AnnotationConfigApplicationContext를 써서 getBean 하지 않아도 autowired로 가져올 수 있나?
     */

}
