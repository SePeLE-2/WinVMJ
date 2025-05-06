package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EventOrganizerServiceComponent implements EventOrganizerService{
	protected RepositoryUtil<EventOrganizer> Repository;

    public EventOrganizerServiceComponent(){
        this.Repository = new RepositoryUtil<EventOrganizer>(TicketingSystem.eventorganizer.core.EventOrganizerComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange);
    public abstract EventOrganizer createEventOrganizer(Map<String, Object> requestBodye);
	public abstract EventOrganizer createEventOrganizer(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateEventOrganizer(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getEventOrganizer(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllEventOrganizer(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<EventOrganizer> List);
    public abstract List<HashMap<String,Object>> deleteEventOrganizer(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getEventOrganizerById(int id);

}
