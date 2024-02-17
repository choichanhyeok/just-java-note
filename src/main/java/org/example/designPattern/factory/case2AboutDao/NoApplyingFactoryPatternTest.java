package org.example.designPattern.factory.case2AboutDao;

import org.example.designPattern.factory.case2AboutDao.domain.gift.GiftDao;
import org.example.designPattern.factory.case2AboutDao.domain.product.Product;
import org.example.designPattern.factory.case2AboutDao.domain.product.ProductDao;
import org.example.designPattern.factory.case2AboutDao.domain.user.User;
import org.example.designPattern.factory.case2AboutDao.domain.user.UserDao;
import org.example.designPattern.factory.case2AboutDao.infra.DatabaseManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoApplyingFactoryPatternTest {

    @BeforeEach
    public void init(){
        DatabaseManager.initAllDatabase();
    }

    @Test
    public void DAO_패턴에_Factory를_적용하지_않은_경우() {
        // given
        String dbType = "oracle";

        GiftDao giftDao;
        ProductDao productDao;
        UserDao userDao;

        // when
        if (dbType.equalsIgnoreCase("oracle")){                 // TODO 1. 개선 필요한 부분
            giftDao = AppConfig.getGiftOracleDaoImpl();
            productDao = AppConfig.getProductOracleDaoImpl();
            userDao = AppConfig.getUserOracleDaoImpl();
        } else if (dbType.equalsIgnoreCase("mysql")){
            giftDao = AppConfig.getGiftMysqlDaoImpl();
            productDao = AppConfig.getProductMysqlDaoImpl();
            userDao = AppConfig.getUserMysqlDaoImpl();
        } else {
            throw new RuntimeException("DB Connection fail");
        }

        try {
            userDao.insertUser(new User("hyeok96", "chanhyeok", "A+"));
            userDao.insertUser(new User("nick33", "nick", "C"));
            userDao.deleteUser("nick33");
            userDao.updateUser(new User("hyeok96", "chanhyeok", "S+"));
            userDao.insertUser(new User("gain99", "gain", "B"));
            productDao.insertProduct(new Product("00ff0ff", "아이폰 22", "2"));
        } catch (Exception e){
            throw new RuntimeException("유저 및 상품 정보 관리 작업 실패");
        }

        // then
        Assertions.assertEquals(4, DatabaseManager.allDatabaseRowSize());

    }

}
