package TicketingSystem.eventorganizer.core;

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


@Entity(name="eventorganizer_impl")
@Table(name="eventorganizer_impl")
public class EventOrganizerImpl extends EventOrganizerComponent {

	public EventOrganizerImpl(int id, String name, String email, String location, EventImpl eventimpl) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.location = location;
		this.eventimpl = eventimpl;
	}

	public EventOrganizerImpl(String name, String email, String location, EventImpl eventimpl) {
		this.id =  id.randomUUID();;
		this.name = name;
		this.email = email;
		this.location = location;
		this.eventimpl = eventimpl;
	}

	public EventOrganizerImpl() { }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> eventorganizerMap = new HashMap<String,Object>();
		eventorganizerMap.put("id",getId());
		eventorganizerMap.put("name",getName());
		eventorganizerMap.put("email",getEmail());
		eventorganizerMap.put("location",getLocation());
		eventorganizerMap.put("eventimpl",getEventimpl());

        return eventorganizerMap;
    }

}
