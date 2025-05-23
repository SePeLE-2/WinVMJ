package TicketingSystem.bundling.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import TicketingSystem.ticket.core.TicketImpl;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "bundling_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BundlingComponent implements Bundling {
	@Id
	protected UUID id;
	protected String bundlingName;
	protected int price;
	protected int availability;
	@ManyToOne(targetEntity = TicketingSystem.ticket.core.TicketImpl.class)
	public TicketImpl ticketimpl;
	protected String objectName = BundlingComponent.class.getName();

	public BundlingComponent() {

	}

	public UUID getId() {
		return this.id;
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

	public TicketImpl getTicketimpl() {
		return this.ticketimpl;
	}

	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	protected void purchase() {
		this.availability--;
	}

	@Override
	public String toString() {
		return "{" +
				" id='" + getId() + "'" +
				" bundlingName='" + getBundlingName() + "'" +
				" price='" + getPrice() + "'" +
				" availability='" + getAvailability() + "'" +
				" ticketimpl='" + getTicketimpl() + "'" +
				"}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> bundlingMap = new HashMap<String, Object>();
		bundlingMap.put("id", getId());
		bundlingMap.put("bundlingName", getBundlingName());
		bundlingMap.put("price", getPrice());
		bundlingMap.put("availability", getAvailability());
		bundlingMap.put("ticketimpl", getTicketimpl());

		return bundlingMap;
	}

}
