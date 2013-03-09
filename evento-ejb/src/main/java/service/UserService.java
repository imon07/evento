package service;

import dao.UserDao;
import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/19/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    private User user;

    protected final Log log = LogFactory.getLog(getClass());

    public void signUpService(User user) {
        userDao.insertUser(user);
    }

    public Integer logInService(User user) {
        user = userDao.getUser(user);
        log.info("logInService: " + user);
        if(user == null) {
            return null;
        } else {
            System.out.println("logInService: " + user.getId());
            return user.getId();
        }
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
