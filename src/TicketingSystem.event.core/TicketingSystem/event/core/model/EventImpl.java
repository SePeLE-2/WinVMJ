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
		this.idEvent = UUID.randomUUID();
		this.name = "";
		this.date = "";
		this.location = "";
		this.description = "";
		this.ticketimpl = null;
		this.bundlingimpl = null;
	}
}
