package org.example.exception.checkedException.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionCaseTest {

    @DisplayName("IOException 발생 테스트 1")
    @Test
    protected void test1() {
        Assertions.assertThrows(IOException.class, () -> {
            BufferedReader br = new BufferedReader(new FileReader("foo.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        });
    }


    @DisplayName("IOException 발생 테스트 2")
    @Test
    protected void test2() {
        Assertions.assertThrows(IOException.class, () -> {
            BufferedReader br = new BufferedReader(new FileReader("뭐 짜샤.txt"));
            String line;

            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        });
    }

}

