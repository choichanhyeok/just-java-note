package org.example.springAop.Aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.springAop.resource.AspectTestResource;
import org.springframework.stereotype.Component;



@Aspect
@Component // Spring 컨테이너가 관리하도록 Component로 등록
public class LoggingAspect {

    // Pointcut 정의: 모든 서비스의 모든 메소드를 대상으로 함
    @Pointcut("execution(* org.example.springAop..*Service.*(..))")
    public void serviceMethods() {}

    // Advice 정의: 메소드 실행 전에 수행될 로직
    @Before("serviceMethods()")
    public void beforeServiceMethod() {
        System.out.println("Before executing service method");
    }

    // 메소드가 성공적으로 반환된 후 실행될 Advice
    @AfterReturning("serviceMethods()")
    public void afterReturningServiceMethod() {
        AspectTestResource.check();
        System.out.println("After returning from service method");
    }
}