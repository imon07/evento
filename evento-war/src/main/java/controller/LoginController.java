package controller;

import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/13/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class LoginController {

    private User user;
    private FacesContext facesContext;
    private HttpSession session;
    private ExternalContext externalContext;

    @EJB
    private UserService userService;

    protected final Log log = LogFactory.getLog(getClass());

    @PostConstruct
    public void startUp() {
        log.info("index-user-before: " + user);
        if (user == null) {
            user = new User();
            log.info("index-user-after: " + user);
        }
    }

    public String logIn() {
        if (user != null) {
            Integer id = userService.logInService(user);
            System.out.println("logIn - id: " + id);
            if (id != null) {
                facesContext = FacesContext.getCurrentInstance();
                externalContext = facesContext.getExternalContext();
                session = (HttpSession) externalContext.getSession(true);
                System.out.println("session-create: " + session);
                System.out.println("logIn-user: " + user + " / " + id);
                session.setAttribute("userId", id);
                return "home.xhtml?faces-redirect=true";
            } else {
                return "index.xhtml?faces-redirect=true";
            }
        }
        return "index.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }
}
