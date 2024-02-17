package org.example.designPattern.factory.case2AboutDao.domain.gift;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseOracle;

public class GiftOracleDaoImpl implements GiftDao{
    @Override
    public void deleteGift(Gift gift) { VirtualDataBaseOracle.deleteGift(gift.getName()); }

    @Override
    public void insertGift(Gift gift) {
        VirtualDataBaseOracle.insertGift(gift.getName(), gift);
    }

    @Override
    public void updateGift(Gift gift) { VirtualDataBaseOracle.updateGift(gift.getName(), gift); }

}
