package TicketingSystem.event.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class EventResourceDecorator extends EventResourceComponent{
	protected EventResourceComponent record;

    public EventResourceDecorator(EventResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveEvent(VMJExchange vmjExchange){
		return record.saveEvent(vmjExchange);
	}

    public Event createEvent(VMJExchange vmjExchange){
		return record.createEvent(vmjExchange);
	}

    public Event createEvent(VMJExchange vmjExchange, int id){
		return record.createEvent(vmjExchange, id);
	}

    public HashMap<String, Object> updateEvent(VMJExchange vmjExchange){
		return record.updateEvent(vmjExchange);
	}

    public HashMap<String, Object> getEvent(VMJExchange vmjExchange){
		return record.getEvent(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllEvent(VMJExchange vmjExchange){
		return record.getAllEvent(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteEvent(VMJExchange vmjExchange){
		return record.deleteEvent(vmjExchange);
	}

	public void createEvent() {
		return record.createEvent();
	}

	public String getDetails() {
		return record.getDetails();
	}
}
