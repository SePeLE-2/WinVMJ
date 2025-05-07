package TicketingSystem.event.rating;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.event.core.EventServiceDecorator;
import TicketingSystem.event.core.EventImpl;
import TicketingSystem.event.core.EventServiceComponent;

public class EventServiceImpl extends EventServiceDecorator {
    public EventServiceImpl (EventServiceComponent record) {
        super(record);
    }

    
	public void addRating() {
		// TODO: implement this method
	}

	public int getAverageRating() {
		// TODO: implement this method
	}
}
