package org.example.threadSafety.liveLock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LiveLockTest {
    private int bowCount;

    @DisplayName("LiveLockTest(1): LiveLock 발생시켜보기")
    @Test
    private void test1(){
        // given
        final Friend hyeok = new Friend("King");
        final Friend king = new Friend("Hyeok");

        // when
        new Thread(new Runnable() {
            @Override
            public void run() {
                hyeok.bow(king);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                king.bow(hyeok);
            }
        }).start();

        // then
        // 이것도 보류

    }


    class Friend {
        private final String name;
        private boolean bowing;

        Friend(String name){
            this.name = name;
        }

        synchronized void bow(Friend bower) {
            bowCount += 1;
            if (bowCount > 100){
                new RuntimeException("인사 너무 많이 해서 허리 부서짐");
            }

            System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.name);

            if (bower.bowing) {
                System.out.format("%s: %s" + " bowed to me, but I'm bowing to them!\n", this.name, bower.name);
                bower.rise();
            } else{
                bowing = true;
                bower.bow(this);
            }

        }

        synchronized void rise() {
            bowing = false;
            System.out.format("%s: I am rising up!%n", this.name);
        }

    }
}
