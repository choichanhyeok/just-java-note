package org.example.collections.collection.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;

public class VectorTest {
    Vector<String> vectorForThreadTest = new Vector<>();

    public VectorTest(){
        this.test1();
    }


    @DisplayName("Vector 학습용 테스트(1): String Type, Vector basic use case")
    @Test
    protected void test1() {
        // given
        Vector<String> wordVector = new Vector();

        // when
        wordVector.add("hi");
        wordVector.add("hyeok");

        wordVector.remove(0);

        // then
        Assertions.assertEquals("hyeok", wordVector.get(0));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            wordVector.get(1);
        });
    }

//    @DisplayName("Vector 학습용 테스트(2): Integer Type, Vector has thread safety.")
//    @Test
//    protected void test2() throws ExecutionException, InterruptedException {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<?> future1 = executorService.submit(new ThreadDemoFirst());
//        Future<?> future2 = executorService.submit(new ThreadDemoSecond());
//
//        future1.get();
//        future2.get();
//
//        Thread.sleep(10000);
//        Assertions.assertEquals("hi", vectorForThreadTest.get(0));
//        Assertions.assertEquals("great", vectorForThreadTest.get(1));
//        Assertions.assertEquals("hyeok", vectorForThreadTest.get(2));
//    }



    class ThreadDemoFirst extends Thread{
        public void run(){
            vectorForThreadTest.add("hi");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            vectorForThreadTest.add("great");
        }
    }

    class ThreadDemoSecond extends Thread{
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            vectorForThreadTest.add("hyeok");
        }
    }
}
