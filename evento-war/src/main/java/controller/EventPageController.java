package controller;

import entities.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import service.EventService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/13/13
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class EventPageController {

    private Event event;
    private Integer organizer = 0;
    private FacesContext facesContext;
    private HttpSession session;
    private Integer userId;
    private Integer publish;

    @EJB
    private EventService eventService;

    protected final Log log = LogFactory.getLog(getClass());

    @PostConstruct
    public void startUp() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if(params.get("eventId") != null) {
            Integer eventId = Integer.valueOf(params.get("eventId"));
            event = eventService.getEventById(eventId);

            facesContext = FacesContext.getCurrentInstance();
            session = (HttpSession) facesContext.getExternalContext().getSession(true);
            userId = (Integer)session.getAttribute("userId");

            organizer = eventService.isUserAnOrganizer(userId, event.getId());
        }
    }

    public String publishEvent() {
        event.setPublish(1);
        eventService.publishEvent(event);
        return "home.xhtml?faces-redirect=true";
    }

    public Integer getPublish() {
        return event.getPublish();
    }

    public String joinEvent() {
        eventService.eventParticipate(userId, event);
        return "event_join_suc.xhtml?faces-redirect=true";
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Integer organizer) {
        this.organizer = organizer;
    }
}
