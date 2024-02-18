package org.example.designPattern.singleton.whyNeedSingleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyingSingleton {
    private final int testConnectionCount = 200;

    @Test
    public void DB_커넥션을_200개_쓰레드가_미친듯이_커넥션을_요구할_때() throws InterruptedException {
        // given
        final List<Thread> threads = new ArrayList<>();
        final List<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());


        // when
        for (int i = 0; i < testConnectionCount; i ++){
            threads.add(new Thread(() -> {
                try { DatabaseConnection.getInstance(); }
                catch (SQLException e) { exceptions.add(e); }

                try { Thread.sleep(100); }
                catch (InterruptedException e) { System.out.println("InterruptedException !!"); }
            }));
        }

        for (Thread thread: threads){
            thread.start();
        }

        // then
        for (Thread thread: threads){
            thread.join();
        }

        Assertions.assertTrue(exceptions.isEmpty(), "요청이 미친듯이 많아도 DB 연결 중 예외 발생치 않음");

        // System.out.println("싱글톤 적용시 DB 커넥션 소요 시간("+ testConnectionCount +" 개 기준): ");
    }


    public static class DatabaseConnection {
        private static DatabaseConnection instance;
        private final Connection con;

        private DatabaseConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/test";
            final String user = "root";
            final String password = "1541";

            this.con = DriverManager.getConnection(url, user, password);
            // System.out.println("DB Connection success: " + con);
        }

        public static DatabaseConnection getInstance() throws SQLException {
            if (instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null){
                        instance = new DatabaseConnection();
                    }
                }
            }
            return instance;
        }
    }
}
