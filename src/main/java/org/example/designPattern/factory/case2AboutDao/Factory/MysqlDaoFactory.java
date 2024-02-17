package org.example.designPattern.factory.case2AboutDao.Factory;

import org.example.designPattern.factory.case2AboutDao.AppConfig;
import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftDao;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductMysqlDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserMysqlDaoImpl;

public class MysqlDaoFactory implements DaoFactory{


    @Override
    public GiftDao getGiftDao() { return AppConfig.getGiftMysqlDaoImpl(); }

    @Override
    public ProductMysqlDaoImpl getProductDao() {
        return AppConfig.getProductMysqlDaoImpl();
    }

    @Override
    public UserMysqlDaoImpl getUserDao() {
        return AppConfig.getUserMysqlDaoImpl();
    }
}
