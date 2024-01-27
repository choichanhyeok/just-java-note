package org.example.threadSafety.deadLock.realCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class BankTransferCase1 {
    private Account accountA;
    private Account accountB;
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    int expectedA;
    int expectedB;

    @BeforeEach
    private void setup(){
        this.accountA = new Account(1, 50000);
        this.accountB = new Account(2, 50000);

        this.executorService = Executors.newFixedThreadPool(2);

        this.expectedA = 45000;
        this.expectedB = 55000;
    }

    @DisplayName("BankTransferCaseTest(1): 사전 할당을 통한 순차적인 락 접근을 일으키지 않을때는 DeadLock 발생")
    @Test
    void test1() throws InterruptedException {
        // given

        // when
        executorService.submit(() -> {
           transferMoney(accountA, accountB, 10000, false);
        });

        executorService.submit(() -> {
            transferMoney(accountB, accountA, 5000, false);
        });

        // then
        executorService.shutdown();
        Assertions.assertFalse(executorService.awaitTermination(10, TimeUnit.SECONDS));
    }


    @DisplayName("BankTransferCaseTest(2): 은행 송금 로직에 순차 접근 락을 적용해 데드락 해소")
    @Test
    void tset2() throws InterruptedException {
        // given

        // when
        executorService.submit(() -> {
            transferMoney(accountA, accountB, 10000, true);
        });
        executorService.submit(() -> {
            transferMoney(accountB, accountA, 5000, true);
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // then
        int actualA = accountA.balance;
        int actualB = accountB.balance;

        Assertions.assertEquals(expectedA, actualA);
        Assertions.assertEquals(expectedB, actualB);
    }

    private final class Account {
        private int balance;
        private int accountId;

        public Account(final int accountId, final int balance){
            this.accountId = accountId;
            this.balance = balance;
        }

        // TODO 1. 입, 출금에 대한 메서드 작성
        public void deposit(int amount){
            this.balance += amount;
        }

        public void withdraw(int amount){
            this.balance -= amount;
        }
    }

    private static void transferMoney(Account fromAccount, Account toAccount, int amount, boolean isTargetOfLockSort){
        Object firstLock;
        Object secondLock;

        if (isTargetOfLockSort) {         // TODO 2. 어떤 계좌가 먼저 들어오더라도 각 계좌에 대한 락 객체를 이용해서 이체 작업에 대한 thread safety를 보장 가능하구나 !
            firstLock = fromAccount.accountId < toAccount.accountId ? fromAccount : toAccount;
            secondLock = fromAccount.accountId > toAccount.accountId ? toAccount : fromAccount;
        }else {
            firstLock = fromAccount;
            secondLock = toAccount;
        }

        synchronized (firstLock) {
            // TODO 3. 동시성 테스트를 위해 Thread.sleep() 걸어주기
            System.out.println("Thread " + Thread.currentThread().getId() + "is get lock" + ((Account)firstLock).accountId);
            try {
                System.out.println("Thread " + Thread.currentThread().getId() + "is wait .. ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (secondLock) {
                System.out.println("Thread " + Thread.currentThread().getId() + " is get lock" + ((Account)secondLock).accountId);
                if (fromAccount.balance >= amount){
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println( amount + "원 이체 성공!, from: " + fromAccount.balance + ", to: " + fromAccount.balance);
                }else {
                    System.out.println("잔액 부족입니다. 잔고는 다음과 같아용 ~: " + fromAccount.balance);
                }
            }
        }
    }
}
