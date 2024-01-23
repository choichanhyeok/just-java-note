package org.example.collections.map.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Map 써야하냐 DTO 써야하냐의 첨예한 논쟁, 관련해서 꼭 공부하기
 */
public class HashMapTest {

    HashMap<String, Integer> userInfo = new HashMap<String, Integer>();

    @BeforeEach
    public void setup(){
        // given
        userInfo = new HashMap<String, Integer>();
        userInfo.put("hyeok", 29);
        userInfo.put("gain", 28);
        userInfo.put("junpyo", 29);
    }

    @DisplayName("HashMapTest(1): Hashmap method test all in one")
    @Test
    protected void test1() {
        // given
        HashMap<String, Integer> userInfo = new HashMap<String, Integer>();
        userInfo.put("hyeok", 29);
        userInfo.put("gain", 28);
        userInfo.put("junpyo", 29);

        // when & then
        Assertions.assertEquals(29, userInfo.get("hyeok"));
        Assertions.assertEquals(28, userInfo.get("gain"));
    }


    @DisplayName("HashMapTest(2): Hashmap")
    @Test
    protected void test2() {
        // given
        HashMap<String, Integer> userInfo = new HashMap<>();

        // when & then
        for(String key: userInfo.keySet()){
            userInfo.get(key);
        }

        // when


    }


}
