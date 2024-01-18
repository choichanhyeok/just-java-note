package org.example.exception;

import org.example.exception.checkedException.IOException.IOExceptionCaseTest;
import org.example.exception.checkedException.classNotFoundException.ClassNotFoundExceptionTest;
import org.example.exception.uncheckedException.ArithmeticException.ArithmeticExceptionTest;
import org.example.exception.uncheckedException.ArrayIndexOutOfBounds.ArrayIndexOutOfBoundsTest;
import org.example.exception.uncheckedException.nullPointException.NullPointExceptionTest;

public class ExceptionTestRunner {
    public ExceptionTestRunner(){
        new IOExceptionCaseTest();
        new ClassNotFoundExceptionTest();
        new NullPointExceptionTest();
        new ArithmeticExceptionTest();
        new ArrayIndexOutOfBoundsTest();
    }
}
