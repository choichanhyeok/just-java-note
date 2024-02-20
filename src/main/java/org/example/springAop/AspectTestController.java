package org.example.springAop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AspectTestController {

    @Autowired
    private AspectTestService aspectTestService;

    protected void testCall(){
        aspectTestService.testMethod();
    }
}
