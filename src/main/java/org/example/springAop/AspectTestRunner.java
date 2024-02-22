package org.example.springAop;


import org.example.springAop.ComponentScanConfig.BeanConfig;
import org.example.springAop.ComponentScanConfig.ComponentScanConfig;
import org.example.springAop.resource.AspectTestResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTestRunner {

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
    public void 애플리케이션_컨텍스트_객체_생성시에_컴포넌트_스캔_컨피그_클래스_넘겨주면_스캔한다(){ // -> 단, Configuration class에 EnableAspectJ 애노테이션을 적용해야 해당 서비스 클래스에 대한 AOP가 동작한다.
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // when
        AspectTestController aspectTestController = ac.getBean(AspectTestController.class);
        aspectTestController.testCall();

        // then
        Assertions.assertTrue(AspectTestResource.isChecked());

        /**
         * 컴포넌트와 함께 Aspect를 사용하고자 하면, 아래 절차를 따라야 한다.
         *
         * (1) Configuration 애노테이션을 적용하는 별도 config 클래스를 만들어 해당 클래스에 @ComponentScan(탐색_패키지_번호)를 붙여 컴포넌트를 탐색해 빈으로 등록케 한다.
         * (2) 위 1번 까지만 진행해도 AnnotationConfigApplicationContext를 이용해 빈 조회는 가능하다. 단, 이 때 AOP를 타지 못하는 문제가 생기는데
         * (3) 단, 해당 클래스에 EnableAspectJAutoProxy 애노테이션을 붙여 프록시에 등록해줘야
         *
         * (4) 그리고 여기서 내가 실수로 protected class를 만들었음에도 문제 없이 AOP에 적용된 이유는 내부적으로 CGLIB을 사용해서 그렇다. (별도 설정 없는데 왜 CGLIB)이 사용된건지 ..
         * (5) GCLIB와 JDK 동적 프록시를 사용할 경우의 차이
         * #Q1. 스프링 부트에서 부트 러너에 저 컴포넌트 스캔이 있어서 자동으로 빈을 등록해줬는데, 그럼 부트는 그 main 클래스가 컨피그 파일인가?
         * #Q2. 그냥 스프링 프레임워크에서는 어느 시점에 저 ComponentScan을 해야하지? (이미 적용되어 있는 코드들 확인해보기)
         */
    }


    @Test
    public void 컴포넌트_스캔_없이_컨피큐레이션_클레스에_직접_빈_등록해서_AOP_호출시켜보기(){
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
        AspectTestController aspectTestController = ac.getBean(AspectTestController.class);

        // when
        aspectTestController.testCall();

        // then
        Assertions.assertTrue(AspectTestResource.isChecked());
    }

}
