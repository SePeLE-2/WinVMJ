package TicketingSystem.event.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class EventDecorator extends EventComponent {
	@OneToOne(cascade = CascadeType.ALL)
	protected EventComponent record;

	public EventDecorator() {
		super();
		this.record = record;
		this.idEvent = UUID.randomUUID();
	}

	public EventDecorator(EventComponent record) {
		this.idEvent = UUID.randomUUID();
		this.record = record;
	}

	public EventDecorator(UUID idEvent, EventComponent record) {
		this.idEvent = idEvent;
		this.record = record;
	}

	public UUID getIdEvent() {
		return record.getIdEvent();
	}

	public void setIdEvent(UUID idEvent) {
		record.setIdEvent(idEvent);
	}

	public String getName() {
		return record.getName();
	}

	public void setName(String name) {
		record.setName(name);
	}

	public String getDate() {
		return record.getDate();
	}

	public void setDate(String date) {
		record.setDate(date);
	}

	public String getLocation() {
		return record.getLocation();
	}

	public void setLocation(String location) {
		record.setLocation(location);
	}

	public String getDescription() {
		return record.getDescription();
	}

	public void setDescription(String description) {
		record.setDescription(description);
	}

	public void createEvent() {
		record.createEvent();
	}

	public String getDetails() {
		return record.getDetails();
	}

	public HashMap<String, Object> toHashMap() {
		return this.record.toHashMap();
	}

}
