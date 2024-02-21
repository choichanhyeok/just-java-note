package org.example.springAop;


import org.example.springAop.ComponentScanConfig.ComponentScanConfig;
import org.example.springAop.resource.AspectTestResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunAspectTest {

    @Test
    protected void 애초에_스프링_에스펙트고_뭐고_컴포넌트는_컴포넌트_스캔_안하면_빈_등록_안된거다(){
        // TODO 1. 컴포넌트 등록은 이 경우엔 잼병이다, 왜냐면 컴포넌트라는 건 컴포넌트 스캔 이후에 스프링 컨테이너에 등록되는 거여서 해당 컨트롤러 못받아온다.
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext();

        // when & then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            AspectTestController aspectTestController = ac.getBean(AspectTestController.class);
        });
    }

    @Test
    public void 애플리케이션_컨텍스트_객체_생성시에_컴포넌트_스캔_컨피그_클래스_넘겨주면_스캔한다_근데_AOP는_적용이_안돼(){ // -> Configure에 EnableAspectJ를 안해줘서
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // when
        AspectTestController aspectTestController = ac.getBean(AspectTestController.class);
        aspectTestController.testCall();

        // then
        Assertions.assertTrue(AspectTestResource.isChecked());
    }

}
