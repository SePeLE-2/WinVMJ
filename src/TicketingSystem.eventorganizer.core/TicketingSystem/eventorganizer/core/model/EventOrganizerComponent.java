package TicketingSystem.eventorganizer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import TicketingSystem.event.core.EventImpl;
import javax.persistence.ManyToOne;

@Entity
@Table(name="eventorganizer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EventOrganizerComponent implements EventOrganizer{
	@Id
	protected UUID id; 
	protected String name;
	protected String email;
	protected String location;
	@ManyToOne(targetEntity=TicketingSystem.event.core.EventImpl.class)
	public  EventImpl eventimpl;
	protected String objectName = EventOrganizerComponent.class.getName();

	public EventOrganizerComponent() {

	} 

	public EventOrganizerComponent(
        UUID id, String name, String email, String location, EventImpl eventimpl
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.eventimpl = eventimpl;
    }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
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
	public abstract EventImpl getEventimpl();
	public abstract void setEventimpl(EventImpl eventimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " name='" + getName() + "'" +
            " email='" + getEmail() + "'" +
            " location='" + getLocation() + "'" +
            " eventimpl='" + getEventimpl() + "'" +
            "}";
    }
	
}
