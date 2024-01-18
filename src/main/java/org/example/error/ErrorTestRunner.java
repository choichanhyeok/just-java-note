package org.example.error;

import org.example.error.oome.OomeTest;
import org.example.error.stackOverflow.StackOverFlowTest;

public class ErrorTestRunner {
    public ErrorTestRunner(){
        new OomeTest();
        new StackOverFlowTest();
    }
}
