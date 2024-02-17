package org.example.designPattern.factory.case2AboutDao;

import org.example.designPattern.factory.case2AboutDao.Factory.MysqlDaoFactory;
import org.example.designPattern.factory.case2AboutDao.Factory.OracleDaoFactory;
import org.example.designPattern.factory.case2AboutDao.domain.gift.Gift;
import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftMysqlDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftOracleDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductMysqlDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductOracleDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserMysqlDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserOracleDaoImpl;

public class AppConfig {

    public static MysqlDaoFactory getDaoMySqlFactory() { return new MysqlDaoFactory(); }

    public static OracleDaoFactory getDaoOracleFactory() { return new OracleDaoFactory(); }

    public static GiftMysqlDaoImpl getGiftMysqlDaoImpl() { return new GiftMysqlDaoImpl(); }

    public static GiftOracleDaoImpl getGiftOracleDaoImpl() { return new GiftOracleDaoImpl(); }

    public static ProductMysqlDaoImpl getProductMysqlDaoImpl() { return new ProductMysqlDaoImpl(); }

    public static ProductOracleDaoImpl getProductOracleDaoImpl() { return new ProductOracleDaoImpl(); }

    public static UserMysqlDaoImpl getUserMysqlDaoImpl() { return new UserMysqlDaoImpl(); }

    public static UserOracleDaoImpl getUserOracleDaoImpl() { return new UserOracleDaoImpl(); }

}
