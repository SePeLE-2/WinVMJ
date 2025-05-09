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
import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

@Entity(name = "event_impl")
@Table(name = "event_impl")
public class EventImpl extends EventComponent {

	public EventImpl(
			UUID idEvent, String name, String date, String location, String description, TicketImpl ticketimpl,
			BundlingImpl bundlingimpl) {
		this.idEvent = idEvent;
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.ticketimpl = ticketimpl;
		this.bundlingimpl = bundlingimpl;
	}

	public EventImpl(String name, String date, String location, String description, TicketImpl ticketimpl,
			BundlingImpl bundlingimpl) {
		this.idEvent = UUID.randomUUID();
		;
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.ticketimpl = ticketimpl;
		this.bundlingimpl = bundlingimpl;
	}

	public EventImpl() {
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

	public BundlingImpl getBundlingimpl() {
		return this.bundlingimpl;
	}

	public void setBundlingimpl(BundlingImpl bundlingimpl) {
		this.bundlingimpl = bundlingimpl;
	}

	public TicketImpl getTicketimpl() {
		return this.ticketimpl;
	}

	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	public void createEvent() {
		// TODO: implement this method
		System.out.println("createEvent() called in service; this should ideally be in entity logic.");
	}

	public String getDetails() {
		// TODO: implement this method
		System.out.println("getDetails() called in service; this should ideally be in entity logic.");
		return "getDetails() called in service; this should ideally be in entity logic.";
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
