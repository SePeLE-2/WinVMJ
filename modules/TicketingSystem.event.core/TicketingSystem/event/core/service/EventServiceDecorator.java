package TicketingSystem.event.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class EventServiceDecorator extends EventServiceComponent{
	protected EventServiceComponent record;

    public EventServiceDecorator(EventServiceComponent record) {
        this.record = record;
    }

	public EventImpl createEvent(Map<String, Object> requestBody){
		return record.createEvent(requestBody);
	}

    public Event createEvent(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createEvent(requestBody, response);
	}

	public HashMap<String, Object> getEvent(Map<String, Object> requestBody){
		return record.getEvent(requestBody);
	}

	public List<HashMap<String,Object>> getAllEvent(Map<String, Object> requestBody){
		return record.getAllEvent(requestBody);
	}

    public List<HashMap<String,Object>> saveEvent(VMJExchange vmjExchange){
		return record.saveEvent(vmjExchange);
	}

    public HashMap<String, Object> updateEvent(Map<String, Object> requestBody){
		return record.updateEvent(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Event> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteEvent(Map<String, Object> requestBody){
		return record.deleteEvent(requestBody);
	}

	public HashMap<String, Object> getEventById(int id){
        return record.getEventById(id);
    }

	public void createEvent() {
		return record.createEvent();
	}

	public String getDetails() {
		return record.getDetails();
	}
}
