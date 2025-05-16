package TicketingSystem.event.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class EventServiceComponent implements EventService {
    protected RepositoryUtil<Event> eventRepository;

    public EventServiceComponent() {
        this.eventRepository = new RepositoryUtil<Event>(TicketingSystem.event.core.EventComponent.class);
    }

    public abstract Event saveEvent(HashMap<String, Object> body, String email);

    // public abstract Event createEvent(Map<String, Object> requestBodye);

    // public abstract Event createEvent(Map<String, Object> requestBody,
    // Map<String, Object> response);

    public abstract Event updateEvent(Map<String, Object> requestBody);

    public abstract Event getEvent(UUID Id);

    public abstract List<Event> getAllEvent();

    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Event> List);

    public abstract List<Event> deleteEvent(UUID Id);

    // public abstract Event getEventById(UUID Id);

    public abstract void createEvent();

    public abstract String getDetails();
}
