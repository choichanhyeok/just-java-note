package org.example.exception.checkedException.classNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class ClassNotFoundExceptionTest {

    @DisplayName("잘못된 클래스 정보 호출")
    @Test
    protected void test1(){
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            try{
                Class.forName("com.example.exception.foo");
            } catch (ClassNotFoundException e){
                throw new ClassNotFoundException();
            }
        });
    }

    @DisplayName("동적 클래스 로딩 실패")
    @Test
    protected void test2(){
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            ClassLoader classLoader = dummy.class.getClassLoader();
            classLoader.loadClass("com.example.exception.foo");
        });
    }

//    @DisplayName("직렬화 실패")
//    @Test
//    protected void test3(){
//        Assertions.assertThrows(ClassNotFoundException.class, () -> {
//            // 존재하지 않는 클래스의 직렬화된 데이터를 가정
//            byte[] serializedData = {/* 직렬화 데이터 */};
//
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            objectInputStream.readObject(); // ClassNotFoundException 발생
//        });
//    }

    class dummy{}
}
