package org.example.exception.checkedException.classNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class ClassNotFoundExceptionTest {

    @DisplayName("�߸��� Ŭ���� ���� ȣ��")
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

    @DisplayName("���� Ŭ���� �ε� ����")
    @Test
    protected void test2(){
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            ClassLoader classLoader = dummy.class.getClassLoader();
            classLoader.loadClass("com.example.exception.foo");
        });
    }

//    @DisplayName("����ȭ ����")
//    @Test
//    protected void test3(){
//        Assertions.assertThrows(ClassNotFoundException.class, () -> {
//            // �������� �ʴ� Ŭ������ ����ȭ�� �����͸� ����
//            byte[] serializedData = {/* ����ȭ ������ */};
//
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            objectInputStream.readObject(); // ClassNotFoundException �߻�
//        });
//    }

    class dummy{}
}
