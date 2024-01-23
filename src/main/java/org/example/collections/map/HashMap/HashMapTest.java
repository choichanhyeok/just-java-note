package org.example.collections.map.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 써야하냐 DTO 써야하냐의 첨예한 논쟁, 관련해서 꼭 공부하기
 */
public class HashMapTest {

    Map<String, Integer> userInfo = new HashMap<String, Integer>();

    @BeforeEach
    public void setup(){
        // given
        userInfo = new HashMap<String, Integer>();
        userInfo.put("hyeok", 29);
        userInfo.put("gain", 29);
        userInfo.put("junpyo", 30);
    }

    @DisplayName("HashMapTest(1): Hashmap method test all in one")
    @Test
    protected void test1() {
        // given

        // when & then
        Assertions.assertEquals(29, userInfo.get("hyeok"));
        Assertions.assertEquals(29, userInfo.get("gain"));
    }

    @DisplayName("HashMapTest(2): Hashmap")
    @Test
    protected void test2() {
        // given
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("hyeok", 29);
        expected.put("gain", 29);
        expected.put("junpyo", 30);

        // when & then
        for (String key: userInfo.keySet()){
            Assertions.assertTrue(expected.containsKey(key));
        }
    }
}
