package TicketingSystem.event.rating;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.event.core.EventDecorator;
import TicketingSystem.event.core.Event;
import TicketingSystem.event.core.EventComponent;

@Entity(name="event_rating")
@Table(name="event_rating")
public class EventImpl extends EventDecorator {

	public EventImpl(
        super();
        this.objectName = EventImpl.class.getName();
    }
    
    public EventImpl(Rating rating) {
    	super();
		this.objectName = EventImpl.class.getName();
    }
	
	public EventImpl(EventComponent record, Rating rating) {
		super(record);
		this.objectName = EventImpl.class.getName();
	}


	public void addRating() {
		// TODO: implement this method
	}

	public int getAverageRating() {
		// TODO: implement this method
	}

}
