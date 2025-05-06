package TicketingSystem.event.seatmapping;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.event.core.EventDecorator;
import TicketingSystem.event.core.Event;
import TicketingSystem.event.core.EventComponent;

@Entity(name="event_seatmapping")
@Table(name="event_seatmapping")
public class EventImpl extends EventDecorator {

	public EventImpl(
        super();
        this.objectName = EventImpl.class.getName();
    }
    
    public EventImpl(Seat seat) {
    	super();
		this.objectName = EventImpl.class.getName();
    }
	
	public EventImpl(EventComponent record, Seat seat) {
		super(record);
		this.objectName = EventImpl.class.getName();
	}


	public boolean assignSeat() {
		// TODO: implement this method
	}

	public void getAvailableSeats() {
		// TODO: implement this method
	}

	public void getSeatForUser() {
		// TODO: implement this method
	}

}
