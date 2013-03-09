package controller;

import entities.Event;
import service.EventService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
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
public class SearchController {

    private List<Event> searchList;
    private Integer searchListSize;
    private String searchTag;

    @EJB
    private EventService eventService;

    @PostConstruct
    public void startUp() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(params.get("q") != null) {
            String searchTag = params.get("q");
            searchList = eventService.searchEvents(searchTag);
        }
    }

    public String search() {
        return "search.xhtml?q=" + searchTag + "&faces-redirect=true";
    }

    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = searchTag;
    }

    public List<Event> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<Event> searchList) {
        this.searchList = searchList;
    }

    public Integer getSearchListSize() {
        return searchList.size();
    }
}
