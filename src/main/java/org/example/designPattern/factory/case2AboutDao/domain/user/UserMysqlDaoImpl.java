package org.example.designPattern.factory.case2AboutDao.domain.user;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseMysql;

public class UserMysqlDaoImpl implements UserDao{

    @Override
    public void deleteUser(final String name) { VirtualDataBaseMysql.deleteUser(name); }

    @Override
    public void insertUser(final User user) {
        VirtualDataBaseMysql.insertUser(user.getName(), user);
    }

    @Override
    public void updateUser(final User user) { VirtualDataBaseMysql.updateUser(user.getName(), user); }
}
