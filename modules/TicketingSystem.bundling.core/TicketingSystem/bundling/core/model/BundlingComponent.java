package TicketingSystem.bundling.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="bundling_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BundlingComponent implements Bundling{
	@Id
	protected int id; 
	protected String bundlingName;
	protected int price;
	protected int availability;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  ticketimpl;
	protected String objectName = BundlingComponent.class.getName();

	public BundlingComponent() {

	} 

	public BundlingComponent(
        int id, String bundlingName, int price, int availability, TicketImpl ticketimpl
    ) {
        this.id = id;
        this.bundlingName = bundlingName;
        this.price = price;
        this.availability = availability;
        this.ticketimpl = ticketimpl;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
	public abstract TicketImpl getTicketimpl();
	public abstract void setTicketimpl(TicketImpl ticketimpl);
	
 
	protected abstract void purchase();

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
	
}
