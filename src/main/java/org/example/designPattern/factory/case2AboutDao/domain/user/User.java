package org.example.designPattern.factory.case2AboutDao.domain.user;

public class User {
    private String id;
    private String name;
    private String grade;

    public User(final String id, final String name, final String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getName(){
        return this.name;
    }
}
