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


@Entity(name="ticket_impl")
@Table(name="ticket_impl")
public class TicketImpl extends TicketComponent {

	public TicketImpl(int id, String eventName, String ticketName, int price, int availability) {
		this.id = id;
		this.eventName = eventName;
		this.ticketName = ticketName;
		this.price = price;
		this.availability = availability;
	}

	public TicketImpl(String eventName, String ticketName, int price, int availability) {
		this.id =  id.randomUUID();;
		this.eventName = eventName;
		this.ticketName = ticketName;
		this.price = price;
		this.availability = availability;
	}

	public TicketImpl() { }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getTicketName() {
		return this.ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
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

	public void purchase() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> ticketMap = new HashMap<String,Object>();
		ticketMap.put("id",getId());
		ticketMap.put("eventName",getEventName());
		ticketMap.put("ticketName",getTicketName());
		ticketMap.put("price",getPrice());
		ticketMap.put("availability",getAvailability());

        return ticketMap;
    }

}
