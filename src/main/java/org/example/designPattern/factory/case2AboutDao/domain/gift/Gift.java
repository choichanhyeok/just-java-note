package org.example.designPattern.factory.case2AboutDao.domain.gift;

public class Gift {
    private String id;
    private String name;

    public Gift(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){ return this.name; }

}
