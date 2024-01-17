package org.example.exception.checkedException.IOException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionCase {
    public IOExceptionCase() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("똥꾸멍.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

