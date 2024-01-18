package org.example.exception.checkedException.classNotFoundException;

public class ClassNotFoundTestStarter {
    ClassNotFoundExceptionTest classNotFoundExceptionTest = new ClassNotFoundExceptionTest();

    public ClassNotFoundTestStarter(){
        classNotFoundExceptionTest.test1();
        classNotFoundExceptionTest.test2();
        // classNotFoundExceptionTest.test3();
    }
}
