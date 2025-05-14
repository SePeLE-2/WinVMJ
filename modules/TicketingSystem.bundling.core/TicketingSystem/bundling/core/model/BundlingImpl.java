package TicketingSystem.bundling.core;

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

@Entity(name = "bundling_impl")
@Table(name = "bundling_impl")
public class BundlingImpl extends BundlingComponent {

	public BundlingImpl(UUID id, String bundlingName, int price, int availability, TicketImpl ticketimpl) {
		this.id = id;
		this.bundlingName = bundlingName;
		this.price = price;
		this.availability = availability;
		this.ticketimpl = ticketimpl;
	}

	public BundlingImpl(String bundlingName, int price, int availability, TicketImpl ticketimpl) {
		this.id = UUID.randomUUID();
		this.bundlingName = bundlingName;
		this.price = price;
		this.availability = availability;
		this.ticketimpl = ticketimpl;
	}

	public BundlingImpl() {
		this.id = UUID.randomUUID();
		this.bundlingName = "";
		this.price = 0;
		this.availability = 0;
		this.ticketimpl = null;
	}
}