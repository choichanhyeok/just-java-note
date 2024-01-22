package org.example.collections.collection.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;
import java.util.concurrent.*;

public class VectorTest {
    Vector<Integer> vectorForThreadTest = new Vector<>();
    final int ITERATOR_SIZE = 100;
    final int[] answer = new int[ITERATOR_SIZE];

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

    @DisplayName("Vector 학습용 테스트(2): Integer Type, Vector has thread safety.")
    @Test
    protected void test2() throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future1 = executorService.submit(new ThreadDemoFirst());
        Future future2 = executorService.submit(new ThreadDemoSecond());

        future1.get(1, TimeUnit.SECONDS);
        future2.get(1, TimeUnit.SECONDS);

        // 현실적으로 불가능 판단.
    }



    class ThreadDemoFirst extends Thread{
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < ITERATOR_SIZE; i ++){
                vectorForThreadTest.add(i);
            }
        }
    }

    class ThreadDemoSecond extends Thread{
        public void run() {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0 ; i < ITERATOR_SIZE; i ++){
                answer[i] = vectorForThreadTest.get(i);
            }
        }
    }
}
