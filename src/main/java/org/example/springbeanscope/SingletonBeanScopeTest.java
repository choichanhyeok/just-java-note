package org.example.springbeanscope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonBeanScopeTest {

    @Test
    public void 싱글톤_스코프는_항상_같은_객체를_반환한다(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        // TODO 1. ac로부터 Singleton Bean 2개를 받아보자.
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        ac.close();
        System.out.println("SingletonBean1: " + singletonBean1);
        System.out.println("SingletonBean2: " + singletonBean2);

        // TODO 2. 두 빈이 같은 객체인지 확인해보자
        Assertions.assertEquals(singletonBean1, singletonBean2);

    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init() {
            System.out.println("singleton bean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singleton bean destroy");
        }
    }

}
