package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EventOrganizerResourceComponent implements EventOrganizerResource{
	
	public EventOrganizerResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange);
    public abstract EventOrganizer createEventOrganizer(VMJExchange vmjExchange);
	public abstract EventOrganizer createEventOrganizer(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateEventOrganizer(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getEventOrganizer(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllEventOrganizer(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteEventOrganizer(VMJExchange vmjExchange);

}
