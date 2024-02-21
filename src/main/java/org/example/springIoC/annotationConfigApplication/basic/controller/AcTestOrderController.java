package org.example.springIoC.annotationConfigApplication.basic.controller;


import org.example.springIoC.annotationConfigApplication.basic.AppConfig;
import org.example.springIoC.annotationConfigApplication.basic.service.AcTestOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AcTestOrderController {

    @Autowired
    AcTestOrderService acTestOrderServiceWithAutowired;

    @DisplayName("빈 애노테이션을 통해 등록된 서비스 주입받기(1): 기본 적용")
    @Test
    public void findAll(){
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        AcTestOrderService acTestOrderService = ac.getBean("testOrderService", AcTestOrderService.class);

        // then
        Assertions.assertEquals("상품hyeok01", acTestOrderService.findAllOrder().getName());
    }

    @DisplayName("빈 애노테이션을 통해 등록된 서비스 주입받기(2): 클래스 타입만 지정해줘도 찾아옴")
    @Test
    public void findAllType2(){
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        AcTestOrderService acTestOrderService = ac.getBean(AcTestOrderService.class);

        // then
        Assertions.assertEquals("상품hyeok01", acTestOrderService.findAllOrder().getName());
    }

    @DisplayName("빈 애노테이션을 통해 등록된 서비스 주입받기(3): 여기서도 autowired 적용 가능")
    @Test
    public void findAllType3() {
        // 단, Test 애노테이션 적용시 스프링의 관리를 벗어나니까 @Autowired 적용 불가! 테스트 시에 빈 주입 사용하려면 Configuration을 추가해줘야함.
        // when & then
        Assertions.assertThrows(NullPointerException.class, () -> {
            acTestOrderServiceWithAutowired.findAllOrder().getName();
        });
    }

}
