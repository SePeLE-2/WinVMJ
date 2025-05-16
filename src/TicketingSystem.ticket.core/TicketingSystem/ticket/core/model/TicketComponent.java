package TicketingSystem.ticket.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TicketComponent implements Ticket {
	@Id
	protected UUID id;
	protected String eventName;
	protected String ticketName;
	protected int price;
	protected int availability;
	protected String objectName = TicketComponent.class.getName();

	public TicketComponent() {

	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
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
		this.availability--;
	}

	@Override
	public String toString() {
		return "{" +
				" id='" + getId() + "'" +
				" eventName='" + getEventName() + "'" +
				" ticketName='" + getTicketName() + "'" +
				" price='" + getPrice() + "'" +
				" availability='" + getAvailability() + "'" +
				"}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> ticketMap = new HashMap<String, Object>();
		ticketMap.put("id", getId());
		ticketMap.put("eventName", getEventName());
		ticketMap.put("ticketName", getTicketName());
		ticketMap.put("price", getPrice());
		ticketMap.put("availability", getAvailability());

		return ticketMap;
	}

}
