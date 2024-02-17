package org.example.designPattern.factory.case2AboutDao.domain.user;

import org.example.designPattern.factory.case2AboutDao.infra.VirtualDataBaseOracle;

public class UserOracleDaoImpl implements UserDao{

    @Override
    public void deleteUser(final String name) { VirtualDataBaseOracle.deleteUser(name); }

    @Override
    public void insertUser(final User user) {
        VirtualDataBaseOracle.insertUser(user.getName(), user);
    }

    @Override
    public void updateUser(final User user) { VirtualDataBaseOracle.updateUser(user.getName(), user); }
}
