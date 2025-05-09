package TicketingSystem.eventorganizer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

import TicketingSystem.event.core.EventImpl;


@MappedSuperclass
public abstract class EventOrganizerDecorator extends EventOrganizerComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected EventOrganizerComponent record;

	public EventOrganizerDecorator () {
		super();
		this.record = record;
		this.id =  UUID.randomUUID();
	}
		
	public EventOrganizerDecorator (EventOrganizerComponent record) {
		this.id =  UUID.randomUUID();
		this.record = record;
	}

	public EventOrganizerDecorator (UUID id, EventOrganizerComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public EventOrganizerDecorator (EventOrganizerComponent record, String objectName) {
		this.id =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}
	public String getLocation() {
		return record.getLocation();
	}
	public void setLocation(String location) {
		record.setLocation(location);
	}

	public EventImpl getEventimpl() {
		return record.getEventimpl();
	}

	public void setEventimpl(EventImpl eventimpl) {
		record.setEventimpl(eventimpl);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
