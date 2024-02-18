package org.example.designPattern.singleton.whyNeedSingleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThisCaseNeedSingleton {

    @Test
    public void DB_커넥션을_200개_쓰레드가_미친듯이_커넥션을_요구할_때() throws InterruptedException {
        // given
        final List<Thread> threads = new ArrayList<>();
        final List<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());


        // when
        for (int i = 0; i < 200; i ++){
            threads.add(new Thread(() -> {
                try { new DatabaseConnection(); }
                catch (SQLException e) { exceptions.add(e); }

                try { Thread.sleep(100); }
                catch (InterruptedException e) { System.out.println("InterruptedException !!"); }
            }));
        }

        for (Thread thread: threads){
            thread.start();
        }

        for (Thread thread: threads){
            thread.join();
        }


        Assertions.assertTrue(!exceptions.isEmpty(), "DB 연결 중 예외 발생" + !exceptions.isEmpty());

//        for (Exception exception: exceptions) {
//            System.out.println( exceptions.get(1).getMessage().toString() );
//        }
    }



    public class DatabaseConnection {
        private final Connection con;

        public DatabaseConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/test";
            final String user = "root";
            final String password = "1541";

            this.con = DriverManager.getConnection(url, user, password);
            // System.out.println("DB Connection success: " + con);
        }
    }
}
