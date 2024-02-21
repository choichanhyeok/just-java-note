package org.example.springAop.ComponentScanConfig;


import org.example.springAop.Aspect.LoggingAspect;
import org.example.springAop.AspectTestController;
import org.example.springAop.AspectTestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@Configuration
public class BeanConfig {

    @Bean
    public AspectTestController aspectTestController(){
        return new AspectTestController();
    }

    @Bean
    public AspectTestService aspectTestService(){
        return new AspectTestService();
    }


    @Bean
    public LoggingAspect loggingAspect(){ // ***** 결국 애스펙트 클래스도 빈으로 등록되어 있어야 사용 가능 !! *****
        return new LoggingAspect();
    }
}
