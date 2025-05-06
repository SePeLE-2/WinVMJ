package TicketingSystem.event.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EventServiceComponent implements EventService{
	protected RepositoryUtil<Event> Repository;

    public EventServiceComponent(){
        this.Repository = new RepositoryUtil<Event>(TicketingSystem.event.core.EventComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveEvent(VMJExchange vmjExchange);
    public abstract Event createEvent(Map<String, Object> requestBodye);
	public abstract Event createEvent(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateEvent(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getEvent(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllEvent(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Event> List);
    public abstract List<HashMap<String,Object>> deleteEvent(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getEventById(int id);

	public abstract void createEvent();

	public abstract String getDetails();
}
