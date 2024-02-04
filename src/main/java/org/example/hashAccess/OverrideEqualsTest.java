package org.example.hashAccess;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

public class OverrideEqualsTest {

    @DisplayName("HashTest(1): equals 정의를 통해 두 객체 비교 기준 변경 가능")
    @Test
    protected void test1(){
        // given
        Person p1 = new Person("chanhyeok", 30);
        Person p2 = new Person("chanhyeok", 30);

        // when
        boolean isSamePerson = p1.equals(p2);

        // then
        Assertions.assertTrue(isSamePerson);
    }


    @DisplayName("HashTest(2): equals 정의와 함께 hashCode를 사용치 않으면 hashMap 사용시 문제가 발생")
    @Test
    protected void test2(){
        // given
        HashMap<Person, String> hashMap = new HashMap<>();
        Person p1 = new Person("chanhyeok", 30);
        Person p2 = new Person("chanhyeok", 30);

        // when
        hashMap.put(p1, "First Entry");
        hashMap.put(p2, "Second Entry");

        // then
        Assertions.assertNotEquals(1, hashMap.size());

        /**
         * p1, p2는 equals 재정의를 했지만 hashCode 재정의는 하지 않아 hashMap에서 put을 사용할 때 서로 다른 객체로 판별됨.
         * 그래서 서로 다른 2개의 요소로 저장돼 1개가 아닌 2개의 크기를 갖게 된다.
         */
    }

    @DisplayName("HashTest(3): equals와 hashCode를 같이 재정의 했을 때 각 객체의 [name] 필드를 기준으로 객체의 동등성을 비교한다")
    @Test
    protected void test3(){
        // given
        HashMap<PersonOverrideHashCode, String> hashMap = new HashMap<>();
        PersonOverrideHashCode p1 = new PersonOverrideHashCode("chanhyeok");
        PersonOverrideHashCode p2 = new PersonOverrideHashCode("chanhyeok");

        // when
        hashMap.put(p1, "First Request");
        hashMap.put(p2, "Second Request");

        // then
        Assertions.assertEquals(1, hashMap.size());
        Assertions.assertEquals("Second Request", hashMap.get(p1));
    }

    private class Person {
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }
    }

    private class PersonOverrideHashCode {
        private String name;

        public PersonOverrideHashCode(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonOverrideHashCode p = (PersonOverrideHashCode) o;
            return Objects.equals(this.name, p.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
