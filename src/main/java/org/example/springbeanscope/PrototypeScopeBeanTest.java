package org.example.springbeanscope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeScopeBeanTest {

    @Test
    public void 프로토타입_빈_스코프는_매번_새로운_객체를_내려준다(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        // TODO 1. 프로토타입 빈 2개를 조회한다
        PrototypeBean findPrototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean findPrototypeBean2 = ac.getBean(PrototypeBean.class);
        ac.close();
        System.out.println("findPrototypeBean1: " + findPrototypeBean1);
        System.out.println("findPrototypeBean2: " + findPrototypeBean2);

        // TODO 2. 두 빈은 다르다.
        Assertions.assertNotEquals(findPrototypeBean1, findPrototypeBean2);

    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("prototype bean init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototype bean destroy");
        }

    }
}
