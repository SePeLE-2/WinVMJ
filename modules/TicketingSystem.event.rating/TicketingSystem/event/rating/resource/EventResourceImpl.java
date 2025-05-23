package TicketingSystem.event.rating;

import TicketingSystem.event.core.*;
import TicketingSystem.event.rating.EventRatingFactory;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import java.util.*;

public class EventResourceImpl extends EventResourceDecorator {
    private RepositoryUtil<Event> eventratingRepository;
    private EventService eventService;

    public EventResourceImpl(EventResourceComponent record, EventServiceComponent eventService) {
        super(record);
        this.eventService = eventService;
        try {
            this.eventratingRepository = new RepositoryUtil<>(
                (Class<Event>) Class.forName("TicketingSystem.event.rating.EventImpl")
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("EventImpl class not found", e);
        }
    }

    @Route(url = "call/rating/save")
    public HashMap<String, Object> saveEvent(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS"))
            return null;

        UUID id = UUID.randomUUID();
        String name = (String) vmjExchange.getRequestBodyForm("name");
        String date = (String) vmjExchange.getRequestBodyForm("date");
        String location = (String) vmjExchange.getRequestBodyForm("location");
        String description = (String) vmjExchange.getRequestBodyForm("description");

        Event event = EventRatingFactory.createEventRating(
                "TicketingSystem.event.rating.EventImpl",
                id, name, date, location, description);
        eventratingRepository.saveObject(event);

        return event.toHashMap();
    }

    public HashMap<String, Object> Event(VMJExchange vmjExchange) {
        return new HashMap<>();
    }

    @Route(url = "call/rating/list")
    public List<HashMap<String, Object>> getAllEvent(VMJExchange vmjExchange) {
        List<Event> list = eventratingRepository.getListObject("event_rating", null, null);
        return transformListToHashMap(list);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Event> list) {
        List<HashMap<String, Object>> result = new ArrayList<>();
        for (Event e : list) {
            result.add(e.toHashMap());
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getEvent(VMJExchange vmjExchange) {
        return record.getEvent(vmjExchange);
    }

    @Override
    public HashMap<String, Object> updateEvent(VMJExchange vmjExchange) {
        return record.updateEvent(vmjExchange);
    }

    @Override
    public List<HashMap<String, Object>> deleteEvent(VMJExchange vmjExchange) {
        return record.deleteEvent(vmjExchange);
    }
}
