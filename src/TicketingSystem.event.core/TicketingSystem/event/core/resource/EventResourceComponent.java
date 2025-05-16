package TicketingSystem.event.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EventResourceComponent implements EventResource {
    protected RepositoryUtil<Event> eventRepository;

    public EventResourceComponent() {
        this.eventRepository = new RepositoryUtil<Event>(
                TicketingSystem.event.core.EventComponent.class);
    }

    public abstract HashMap<String, Object> saveEvent(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> updateEvent(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> getEvent(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> getAllEvent(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> deleteEvent(VMJExchange vmjExchange);

    public abstract void createEvent();

    public abstract String getDetails();
}
