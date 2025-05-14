package TicketingSystem.bundling.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BundlingDecorator extends BundlingComponent {
	@OneToOne(cascade = CascadeType.ALL)
	protected BundlingComponent record;

	public BundlingDecorator() {
		super();
		this.record = record;
		this.id = UUID.randomUUID();
	}

	public BundlingDecorator(BundlingComponent record) {
		this.id = UUID.randomUUID();
		this.record = record;
	}

	public BundlingDecorator(UUID id, BundlingComponent record) {
		this.id = id;
		this.record = record;
	}

	public UUID getId() {
		return record.getId();
	}

	public void setId(UUID id) {
		record.setId(id);
	}

	public String getBundlingName() {
		return record.getBundlingName();
	}

	public void setBundlingName(String bundlingName) {
		record.setBundlingName(bundlingName);
	}

	public int getPrice() {
		return record.getPrice();
	}

	public void setPrice(int price) {
		record.setPrice(price);
	}

	public int getAvailability() {
		return record.getAvailability();
	}

	public void setAvailability(int availability) {
		record.setAvailability(availability);
	}

	protected void purchase() {
		record.purchase();
	}

	public HashMap<String, Object> toHashMap() {
		return this.record.toHashMap();
	}

}
