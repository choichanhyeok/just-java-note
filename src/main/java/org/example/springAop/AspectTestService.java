package org.example.springAop;


import org.springframework.stereotype.Component;

@Component
public class AspectTestService {

    protected void testMethod(){
        System.out.println("AspecAspectTestService testMethod call!!");
    }
}
