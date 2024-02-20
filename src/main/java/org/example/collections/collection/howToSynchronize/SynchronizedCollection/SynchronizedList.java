package org.example.collections.collection.howToSynchronize.SynchronizedCollection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {
    @DisplayName("")
    @Test
    public void test1(){
        // given
        List unsyncList = new ArrayList<>();


        // when
        List<String> synchronizedList = Collections.synchronizedList(unsyncList); // SynchronizedList로 형변환해주는 역할.


        // then
        // 동기화된 리스트에서 요소 읽기, 이럴거면 왜 해주는거야?
        synchronized (synchronizedList) {
            for (String language : synchronizedList) {
                System.out.println(language);
            }
        }
    }
}
