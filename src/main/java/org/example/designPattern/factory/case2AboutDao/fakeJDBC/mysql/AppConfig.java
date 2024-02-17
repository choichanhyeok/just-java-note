package org.example.designPattern.factory.case2AboutDao.fakeJDBC.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppConfig {

    public Connection getConnection(){
        return new FakeConnectionMysql();
    }

    public Statement getStatement(){
        return new FakeStatementMysql();
    }

    public ResultSet getResultSet(){
        return new FakeResultSetMysql();
    }
}
