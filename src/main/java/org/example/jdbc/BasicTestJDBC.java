package org.example.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class BasicTestJDBC {

    @DisplayName("BasicTestJDBC(1): 데이터베이스 연동 테스트")
    @Test
    protected void test1(){
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "1541";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("success connection Database!!");

            // TODO 1. 작업 진행

            String query = "SELECT * FROM student WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "hyeok");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String data = resultSet.getString("name");
                System.out.println(data);
            }

            // TODO 2. 자원 해제
            resultSet.close();
            preparedStatement.close();

            // TODO 3. 연결 종료
            connection.close();
            System.out.println("success disconnection Database!!");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail connection DataBase !!");
        }
    }

    @DisplayName("BasicTestJDBC(2): preparedStatement basic test")
    @Test
    public void test2(){
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Slqlrjf12#$";


        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("success connection DATABASE !!");

            // TODO 1. 작업 진행
            String query = "SELECT * FROM student WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "hyeok");
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
               String data = resultSet.getString("name");
               System.out.println(data);
            }

            // TODO 2. 자원 해제
            resultSet.close();
            preparedStatement.close();

            // TODO 3. 연결 종료
            connection.close();
            System.out.println("disconnection DATABASE !!");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail connection DATABASE !!");
        }

    }


    @DisplayName("BasicTestJDBC(3): statement basic test")
    @Test
    protected void test3(){
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Slqlrjf12#$";

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM STUDENT WHERE name = \'hyeok\'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stmt.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail Database transaction");
        }
    }

//    @DisplayName("BasicTestJDBC(4): SQL 인젝션 발생")
//    @Test
//    protected void test4(){
//        String url = "jdbc:mysql://localhost:3306/test";
//        String user = "root";
//        String password = "1541";
//        String userInput = "\'; SELECT * FROM student; \'";
//        try{
//            Connection connection = DriverManager.getConnection(url, user, password);
//            String query = "SELECT * FROM student WHERE name = \'" + userInput + "\'";
//
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//            }
//
//            rs.close();
//            stmt.close();
//            connection.close();
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("CONNECTION IS FAIL");
//        }
//
//
//    }


    @DisplayName("BasicTestJDBC(5): 인덱스 생성 예시")
    @Test
    protected void test5() {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Slqlrjf12#$";

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            String dropTableQuery = "DROP TABLE IF EXISTS users;";

            String createTableQuery = "CREATE TABLE users (\n" +
                    "    user_id INT PRIMARY KEY,\n" +
                    "    last_name VARCHAR(50),\n" +
                    "    first_name VARCHAR(50)\n" +
                    ");";

            String createIndexQuery = "CREATE INDEX idx_last_name ON users(last_name);\n";
            String insertQuery = "INSERT INTO users (user_id, last_name, first_name) VALUES (100, 'Smith', 'fuck');";
            String findUserData = "SELECT * FROM users WHERE last_name = 'Smith';\n";

            Statement stmt = connection.createStatement();
            stmt.execute(dropTableQuery);
            stmt.execute(createTableQuery);
            stmt.execute(createIndexQuery);
            stmt.execute(insertQuery);
            ResultSet rs = stmt.executeQuery(findUserData);

            while(rs.next()){
                System.out.println(rs.getString("last_name"));
            }

            rs.close();
            stmt.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail Database transaction");
        }
    }
}
