package org.example.designPattern.factory.case2AboutDao.infra;

public class DatabaseManager {
    public static void initAllDatabase(){
        VirtualDataBaseMysql.reset();
        VirtualDataBaseOracle.reset();
    }

    public static int allDatabaseRowSize(){
        return (VirtualDataBaseOracle.getRowCount() + VirtualDataBaseMysql.getRowCount());
    }

}
