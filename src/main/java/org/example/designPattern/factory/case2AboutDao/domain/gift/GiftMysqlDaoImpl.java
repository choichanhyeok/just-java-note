package org.example.designPattern.factory.case2AboutDao.domain.gift;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseMysql;

public class GiftMysqlDaoImpl implements GiftDao{
    @Override
    public void deleteGift(Gift gift) {
        VirtualDataBaseMysql.deleteGift(gift.getName());
    }

    @Override
    public void insertGift(Gift gift) {
        VirtualDataBaseMysql.insertGift(gift.getName(), gift);
    }

    @Override
    public void updateGift(Gift gift) {
        VirtualDataBaseMysql.updateGift(gift.getName(), gift);
    }

}
