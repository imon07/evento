package controller;

import entities.Event;
import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import service.EventService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/13/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class HomeController implements Serializable {

    @EJB
    private EventService eventService;

    @EJB
    private UserService userService;

    private User user;
    private FacesContext facesContext;
    private HttpSession session;
    private List<Event> eventList;

    protected final Log log = LogFactory.getLog(getClass());

    @PostConstruct
    public void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(true);
        System.out.println("startUp-session: " + session);
        System.out.println("startUp-1: " + session.getAttribute("userId"));
        try {
            if(user == null) {
                /*user = eventService.getEventByUserId((Integer)session.getAttribute("userId"));
                if(user == null) {*/
                    user = userService.getUserById((Integer)session.getAttribute("userId"));
                    List<Event> events = new ArrayList<Event>();
                    user.setEventList(events);
                    eventList = eventService.getEvents();
                //}
                log.info("homee-user: " + user);
                log.info("home-userId: " + user.getId());
                log.info("home-userEmail: " + user.getEmail());
                log.info("home-userEvent" + user.getEventList().size());
            }
        } catch (NullPointerException ex) {
            log.info("startUp-2: " + session);
        }
    }

    public String destroySession() {
        log.info("session-before-destroy: " + session);
        session.removeAttribute("userId");
        session.removeAttribute("userEmail");
        session.removeAttribute("isLogin");
        session.invalidate();
        log.info("session-after-destroy: " + session);
        return "index.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
