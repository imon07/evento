package controller;

import entities.Event;
import entities.User;
/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.EventService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/13/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class IndexController {

    private User user;
    private List<Event> eventList;


    protected final Logger log = LoggerFactory.getLogger(IndexController.class);

    @EJB
    private UserService userService;

    @EJB
    private EventService eventService;

    @PostConstruct
    public void startUp() {
        log.info("index-user-before: " + user);

        if(user == null) {
            user = new User();
            log.info("index-user-after: " + user);
        }

        eventList = eventService.getLimitedEvents(10);
    }

    public String signUp() {
        log.info("index-user-signup: " + user);
        if(user != null) {
            log.info("index-user-signUpService: " + user);
            log.info("index-user-userService:" + userService);
            userService.signUpService(user);
        }
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
