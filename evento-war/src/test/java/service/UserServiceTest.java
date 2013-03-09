package service;

import dao.UserDao;
import entities.User;
import junit.framework.TestCase;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;

/**
 * Created with IntelliJ IDEA.
 * Author: sahmed
 * Date: 3/6/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class UserServiceTest {

    private UserService userService;
    private UserDao userDao;

    @Deployment
    public static Archive<?> createDeployment() {
        Archive archive = ShrinkWrap.create(JavaArchive.class, "user-service.jar")
                .addPackage(User.class.getPackage());

        System.out.println("UserServiceTest: " + archive.toString(true));

        return archive;
    }

    @Before
    public void startUp() {
        userService = new UserService();
        userDao = EasyMock.createMock(UserDao.class);
        userService.setUserDao(userDao);
    }

    @Test
    public void testLogInService_returnsNull() {
        User user = new User();
        user.setEmail("a@a.com");
        user.setPassword("123");

        EasyMock.expect(userDao.getUser(user)).andReturn(null);
        EasyMock.replay(userDao);

        Object typedUser = userService.logInService(user);
        TestCase.assertNull(typedUser);
    }

    @Test
    public void testLogInService_returnsUserId() {
        User user = new User();
        user.setId(1);
        user.setEmail("a@a.com");
        user.setPassword("123");

        EasyMock.expect(userDao.getUser(user)).andReturn(user);
        EasyMock.replay(userDao);

        Object typedUser = userService.logInService(user);
        TestCase.assertEquals(typedUser, new Integer(1));
    }

}
