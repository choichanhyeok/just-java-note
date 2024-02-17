package org.example.designPattern.factory.case2AboutDao.domain.product;

public class Product {
    private String id;
    private String name;
    private String stock;

    public Product(final String id, final String name, final String stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

}
