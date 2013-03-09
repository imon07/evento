package dao;

import entities.Event;
import entities.User;
import org.w3c.dom.events.EventTarget;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/19/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface EventDao {
    public User getEventByUserId(int userId);

    public List<Event> getAllEvents();

    public Integer insertEvent(Integer userId, Event event);

    public Event getEventById(int eventId);

    public void updateEventPublish(Event event);

    public Event getEventByOrganizerId(Integer organizerId, Integer eventId);

    public void eventParticipate(Integer userId, Event event);

    public List<Event> getLimitedEvents(int limit);

    public List<Event> getEventBySearch(String search);
}
