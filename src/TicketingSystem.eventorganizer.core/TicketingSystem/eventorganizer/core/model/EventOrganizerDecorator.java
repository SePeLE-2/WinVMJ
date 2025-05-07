package TicketingSystem.eventorganizer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class EventOrganizerDecorator extends EventOrganizerComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected EventOrganizerComponent record;

	public EventOrganizerDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public EventOrganizerDecorator (EventOrganizerComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public EventOrganizerDecorator (int id, EventOrganizerComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public EventOrganizerDecorator (EventOrganizerComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public EventOrganizerDecorator() { }

	public int getId() {
		return record.getId();
	}
	public void setId(int id) {
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


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
