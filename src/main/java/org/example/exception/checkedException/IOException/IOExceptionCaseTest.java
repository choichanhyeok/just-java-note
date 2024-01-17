package org.example.exception.checkedException.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class IOExceptionCaseTest {

    @DisplayName("IOExceptionCase 발생 테스트")
    @Test
    void testConstructor() {
        Assertions.assertThrows(IOException.class, () -> {
            new IOExceptionCase();
        });
    }
}

