package org.example.designPattern.factory.case2AboutDao.domain.product;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseOracle;

public class ProductOracleDaoImpl implements ProductDao{
    @Override
    public void deleteProduct(final String name) {
        VirtualDataBaseOracle.deleteProduct(name);
    }

    @Override
    public void insertProduct(final Product product) { VirtualDataBaseOracle.insertProduct(product.getName(), product); }

    @Override
    public void updateProduct(final Product product) { VirtualDataBaseOracle.updateProduct(product.getName(), product); }

}
