package org.example.designPattern.factory.case2AboutDao.Factory;

import org.example.designPattern.factory.case2AboutDao.domain.gift.Gift;
import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftDao;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductDao;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserDao;

public interface DaoFactory {
    public GiftDao getGiftDao();
    public ProductDao getProductDao();
    public UserDao getUserDao();
}
