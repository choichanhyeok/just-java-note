package org.example.designPattern.factory.case2AboutDao.Factory;

import org.example.designPattern.factory.case2AboutDao.AppConfig;
import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftDao;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductOracleDaoImpl;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserOracleDaoImpl;

public class OracleDaoFactory implements DaoFactory{

    @Override
    public GiftDao getGiftDao() { return AppConfig.getGiftOracleDaoImpl(); }

    @Override
    public ProductOracleDaoImpl getProductDao() {
        return AppConfig.getProductOracleDaoImpl();
    }

    @Override
    public UserOracleDaoImpl getUserDao() {
        return AppConfig.getUserOracleDaoImpl();
    }
}
