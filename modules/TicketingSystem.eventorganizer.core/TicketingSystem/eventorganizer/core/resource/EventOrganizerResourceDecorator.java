package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class EventOrganizerResourceDecorator extends EventOrganizerResourceComponent{
	protected EventOrganizerResourceComponent record;

    public EventOrganizerResourceDecorator(EventOrganizerResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange){
		return record.saveEventOrganizer(vmjExchange);
	}

    public EventOrganizer createEventOrganizer(VMJExchange vmjExchange){
		return record.createEventOrganizer(vmjExchange);
	}

    public EventOrganizer createEventOrganizer(VMJExchange vmjExchange, int id){
		return record.createEventOrganizer(vmjExchange, id);
	}

    public HashMap<String, Object> updateEventOrganizer(VMJExchange vmjExchange){
		return record.updateEventOrganizer(vmjExchange);
	}

    public HashMap<String, Object> getEventOrganizer(VMJExchange vmjExchange){
		return record.getEventOrganizer(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllEventOrganizer(VMJExchange vmjExchange){
		return record.getAllEventOrganizer(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteEventOrganizer(VMJExchange vmjExchange){
		return record.deleteEventOrganizer(vmjExchange);
	}

}
