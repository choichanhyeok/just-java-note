package org.example.designPattern.factory.case2AboutDao.infra;

import org.example.designPattern.factory.case2AboutDao.domain.gift.Gift;
import org.example.designPattern.factory.case2AboutDao.domain.product.Product;
import org.example.designPattern.factory.case2AboutDao.domain.user.User;

import java.util.HashMap;
import java.util.Map;

public class VirtualDataBaseMysql {
    private final static Map<String, Gift> gifts = new HashMap();
    private final static Map<String, Product> products = new HashMap();
    private final static Map<String, User> users = new HashMap();

    public static void deleteProduct(final String name){
        products.remove(name);
    }

    public static void deleteGift(final String name) { gifts.remove(name); }

    public static void deleteUser(final String name){ users.remove(name); }

    public static void insertProduct(final String name, final Product product){ products.put(name, product); }

    public static void insertGift(final String name, final Gift gift) { gifts.put(name, gift); }

    public static void insertUser(final String name, final User user){
        users.put(name, user);
    }

    public static void updateProduct(final String name, final Product product){
        insertProduct(name, product);
    }

    public static void updateGift(final String name, final Gift gift) { insertGift(name, gift); }

    public static void updateUser(final String name, final User user){ insertUser(name, user); }

    public static void reset(){
        products.clear();
        users.clear();
    }

    public static int getRowCount(){
        return (products.size() + users.size());
    }

}
