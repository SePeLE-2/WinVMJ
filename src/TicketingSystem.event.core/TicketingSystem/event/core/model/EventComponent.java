package TicketingSystem.event.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

@Entity
@Table(name = "event_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EventComponent implements Event {
	@Id
	protected UUID idEvent;
	protected String name;
	protected String date;
	protected String location;
	protected String description;
	@ManyToOne(targetEntity = TicketingSystem.ticket.core.TicketImpl.class)
	public TicketImpl ticketimpl;
	@ManyToOne(targetEntity = TicketingSystem.bundling.core.BundlingImpl.class)
	public BundlingImpl bundlingimpl;
	protected String objectName = EventComponent.class.getName();

	public EventComponent() {

	}

	public UUID getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(UUID idEvent) {
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

	public TicketImpl getTicketimpl() {
		return this.ticketimpl;
	}

	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	public BundlingImpl getBundlingimpl() {
		return this.bundlingimpl;
	}

	public void setBundlingimpl(BundlingImpl bundlingimpl) {
		this.bundlingimpl = bundlingimpl;
	}

	public void createEvent() {

	}

	public String getDetails() {
		return "{" +
				" idEvent='" + getIdEvent() + "'" +
				" name='" + getName() + "'" +
				" date='" + getDate() + "'" +
				" location='" + getLocation() + "'" +
				" description='" + getDescription() + "'" +
				" ticketimpl='" + getTicketimpl() + "'" +
				" bundlingimpl='" + getBundlingimpl() + "'" +
				"}";
	}

	@Override
	public String toString() {
		return "{" +
				" idEvent='" + getIdEvent() + "'" +
				" name='" + getName() + "'" +
				" date='" + getDate() + "'" +
				" location='" + getLocation() + "'" +
				" description='" + getDescription() + "'" +
				" ticketimpl='" + getTicketimpl() + "'" +
				" bundlingimpl='" + getBundlingimpl() + "'" +
				"}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> eventMap = new HashMap<String, Object>();
		eventMap.put("idEvent", getIdEvent());
		eventMap.put("name", getName());
		eventMap.put("date", getDate());
		eventMap.put("location", getLocation());
		eventMap.put("description", getDescription());
		eventMap.put("ticketimpl", getTicketimpl());
		eventMap.put("bundlingimpl", getBundlingimpl());

		return eventMap;
	}
}
