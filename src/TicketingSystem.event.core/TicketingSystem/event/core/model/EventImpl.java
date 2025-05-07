package TicketingSystem.event.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="event_impl")
@Table(name="event_impl")
public class EventImpl extends EventComponent {

	public EventImpl(int idEvent, String name, String date, String location, String description, TicketImpl ticketimpl, BundlingImpl bundlingimpl) {
		this.idEvent = idEvent;
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.ticketimpl = ticketimpl;
		this.bundlingimpl = bundlingimpl;
	}

	public EventImpl(String name, String date, String location, String description, TicketImpl ticketimpl, BundlingImpl bundlingimpl) {
		this.idEvent =  idEvent.randomUUID();;
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.ticketimpl = ticketimpl;
		this.bundlingimpl = bundlingimpl;
	}

	public EventImpl() { }

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void createEvent() {
		// TODO: implement this method
	}

	public String getDetails() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> eventMap = new HashMap<String,Object>();
		eventMap.put("idEvent",getIdEvent());
		eventMap.put("name",getName());
		eventMap.put("date",getDate());
		eventMap.put("location",getLocation());
		eventMap.put("description",getDescription());
		eventMap.put("ticketimpl",getTicketimpl());
		eventMap.put("bundlingimpl",getBundlingimpl());

        return eventMap;
    }

}
