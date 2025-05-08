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

@Entity(name="bundling_impl")
@Table(name="bundling_impl")
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

	public BundlingImpl() { }

	// public UUID getId() {
	// 	return this.id;
	// }

	@Override
	public void setTicketimpl(TicketImpl ticketimpl) {
    	this.ticketimpl = ticketimpl;
	}

	@Override
	public TicketImpl getTicketimpl() {
    	return this.ticketimpl;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBundlingName() {
		return this.bundlingName;
	}

	public void setBundlingName(String bundlingName) {
		this.bundlingName = bundlingName;
	}
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	protected void purchase() {
		System.out.println("Purchasing " + this.getBundlingName() + " for " + this.getPrice() + " dollars.");
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bundlingMap = new HashMap<String,Object>();
		bundlingMap.put("id",getId());
		bundlingMap.put("bundlingName",getBundlingName());
		bundlingMap.put("price",getPrice());
		bundlingMap.put("availability",getAvailability());
		bundlingMap.put("ticketimpl",getTicketimpl());

        return bundlingMap;
    }

}
