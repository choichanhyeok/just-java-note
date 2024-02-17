package org.example.designPattern.factory.case2AboutDao.domain.user;

public interface UserDao {
    public void insertUser(final User user);
    public void deleteUser(final String user);
    public void updateUser(final User user);
}
