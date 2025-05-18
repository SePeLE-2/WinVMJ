package TicketingSystem.event.rating.service;

import TicketingSystem.event.core.*;
import TicketingSystem.event.rating.EventRatingFactory;

import java.util.*;

public class EventServiceImpl extends EventServiceDecorator {
    public EventServiceImpl(EventServiceComponent record) {
        super(record);
    }

    public void addRating() {
        // Optional: add logic
    }

    public int getAverageRating() {
        // Optional: add logic
        return 0;
    }
}
