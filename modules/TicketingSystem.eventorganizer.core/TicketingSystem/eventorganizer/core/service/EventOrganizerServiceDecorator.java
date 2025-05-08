package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class EventOrganizerServiceDecorator extends EventOrganizerServiceComponent{
	protected EventOrganizerServiceComponent record;

    public EventOrganizerServiceDecorator(EventOrganizerServiceComponent record) {
        this.record = record;
    }

	public EventOrganizerImpl createEventOrganizer(Map<String, Object> requestBody){
		return record.createEventOrganizer(requestBody);
	}

    public EventOrganizer createEventOrganizer(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createEventOrganizer(requestBody, response);
	}

	public HashMap<String, Object> getEventOrganizer(Map<String, Object> requestBody){
		return record.getEventOrganizer(requestBody);
	}

	public List<HashMap<String,Object>> getAllEventOrganizer(Map<String, Object> requestBody){
		return record.getAllEventOrganizer(requestBody);
	}

    public List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange){
		return record.saveEventOrganizer(vmjExchange);
	}

    public HashMap<String, Object> updateEventOrganizer(Map<String, Object> requestBody){
		return record.updateEventOrganizer(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<EventOrganizer> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteEventOrganizer(Map<String, Object> requestBody){
		return record.deleteEventOrganizer(requestBody);
	}

	public HashMap<String, Object> getEventOrganizerById(int id){
        return record.getEventOrganizerById(id);
    }

}
