package org.example.designPattern.factory.case2AboutDao.domain.product;

public interface ProductDao {
    public void deleteProduct(final String name);
    public void insertProduct(final Product product);
    public void updateProduct(final Product product);

}
