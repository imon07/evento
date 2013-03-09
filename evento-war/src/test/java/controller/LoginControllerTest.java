package controller;

import entities.User;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import service.UserService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Author: sahmed
 * Date: 3/6/13
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class LoginControllerTest {

    private LoginController loginController;
    private UserService userService;
    private HttpSession httpSession;
    private ExternalContext externalContext;
    private FacesContext facesContext;
    private User user;

    @Deployment
    public static Archive<?> createDeployment() {
        Archive archive = ShrinkWrap.create(JavaArchive.class, "login-controller.jar")
                .addPackage(User.class.getPackage());

        System.out.println("LoginControllerTest: " + archive.toString(true));

        return archive;
    }

    @Before
    public void startUp() {
        loginController = new LoginController();

        userService = EasyMock.createMock(UserService.class);
        httpSession = EasyMock.createMock(HttpSession.class);
        externalContext = EasyMock.createMock(ExternalContext.class);
        facesContext = ContextMocker.mockFacesContext();

        user = new User();
        user.setId(1);
        user.setEmail("a@a.com");
        user.setPassword("123");

        loginController.setUserService(userService);
        loginController.setUser(user);
    }

    @Test
    public void testLogIn_returnsSuccess_WithUserId() {

        EasyMock.expect(userService.logInService(user)).andReturn(user.getId());
        EasyMock.replay(userService);

        EasyMock.expect(facesContext.getExternalContext()).andReturn(externalContext);
        EasyMock.replay(facesContext);

        EasyMock.expect(externalContext.getSession(true)).andReturn(httpSession);
        httpSession.setAttribute("userId", 1);
        EasyMock.replay(httpSession);
        EasyMock.replay(externalContext);

        Object response = loginController.logIn();

        assertEquals(response, "home.xhtml?faces-redirect=true");
    }

    @Test
    public void testLogIn_returnsFailure_WithNullUserId() {
        EasyMock.expect(userService.logInService(user)).andReturn(null);
        EasyMock.replay(userService);

        Object response = loginController.logIn();

        assertEquals(response, "index.xhtml?faces-redirect=true");
    }

}
