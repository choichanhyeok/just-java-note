package org.example.designPattern.factory.case2AboutDao.domain.product;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseMysql;

public class ProductMysqlDaoImpl implements ProductDao{
    @Override
    public void deleteProduct(final String name) {
        VirtualDataBaseMysql.deleteProduct(name);
    }

    @Override
    public void insertProduct(final Product product) { VirtualDataBaseMysql.insertProduct(product.getName(), product);}

    @Override
    public void updateProduct(final Product product) {
        VirtualDataBaseMysql.updateProduct(product.getName(), product);
    }

}
