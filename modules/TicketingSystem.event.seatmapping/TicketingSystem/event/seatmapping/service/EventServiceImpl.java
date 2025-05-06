package TicketingSystem.event.seatmapping;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.event.core.EventServiceDecorator;
import TicketingSystem.event.core.EventImpl;
import TicketingSystem.event.core.EventServiceComponent;

public class EventServiceImpl extends EventServiceDecorator {
    public EventServiceImpl (EventServiceComponent record) {
        super(record);
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
