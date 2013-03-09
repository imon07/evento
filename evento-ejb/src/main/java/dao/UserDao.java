package dao;

import entities.User;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/17/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface UserDao {
    public void insertUser(User user);

    public User getUser(User user);

    public User getUserById(int userId);
}
