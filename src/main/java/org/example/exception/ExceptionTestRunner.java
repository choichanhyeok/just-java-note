package org.example.exception;

import org.example.exception.checkedException.IOException.IOExceptionTestStarter;
import org.example.exception.checkedException.classNotFoundException.ClassNotFoundTestStarter;
import org.example.exception.uncheckedException.ArithmeticException.ArithmeticExceptionTestStarter;
import org.example.exception.uncheckedException.ArrayIndexOutOfBounds.ArrayIndexOutOfBoundsTest;
import org.example.exception.uncheckedException.nullPointException.NullPointExceptionStarter;

public class ExceptionTestRunner {
    public ExceptionTestRunner(){
        new IOExceptionTestStarter();
        new ClassNotFoundTestStarter();
        new NullPointExceptionStarter();
        new ArithmeticExceptionTestStarter();
        new ArrayIndexOutOfBoundsTest();
    }
}
