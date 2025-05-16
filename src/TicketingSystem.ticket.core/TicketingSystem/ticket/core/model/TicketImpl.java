package TicketingSystem.ticket.core;

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

@Entity(name = "ticket_impl")
@Table(name = "ticket_impl")
public class TicketImpl extends TicketComponent {

	public TicketImpl(UUID id, String eventName, String ticketName, int price, int availability) {
		this.id = id;
		this.eventName = eventName;
		this.ticketName = ticketName;
		this.price = price;
		this.availability = availability;
	}

	public TicketImpl(String eventName, String ticketName, int price, int availability) {
		this.id = UUID.randomUUID();
		this.eventName = eventName;
		this.ticketName = ticketName;
		this.price = price;
		this.availability = availability;
	}

	public TicketImpl() {
		this.id = UUID.randomUUID();
		this.eventName = "";
		this.ticketName = "";
		this.price = 0;
		this.availability = 0;
	}
}
