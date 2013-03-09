package dao;

import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ConversationScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/13/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserDaoImpl implements Serializable, UserDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public void insertUser(User user) {
        log.info("insertUser: " + user);
        entityManager.persist(user);
    }

    @Override
    public User getUser(User user) {
        String email = user.getEmail();
        String pass = user.getPassword();
        TypedQuery<User> query = entityManager.createQuery("SELECT u " +
                                                            "FROM User u " +
                                                            "WHERE u.email = :email AND u.password = :pass",
                                                            User.class);
        query.setParameter("email", email);
        query.setParameter("pass", pass);
        try {
            user = query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
        return user;
    }

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }
}
