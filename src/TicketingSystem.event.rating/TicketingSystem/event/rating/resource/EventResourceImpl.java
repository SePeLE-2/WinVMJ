package TicketingSystem.event.rating.resource;

import TicketingSystem.event.core.*;
import TicketingSystem.event.rating.model.EventImpl;
import TicketingSystem.event.rating.EventRatingFactory;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import java.util.*;

public class EventResourceImpl extends EventResourceDecorator {
    private RepositoryUtil<Event> eventratingRepository = new RepositoryUtil<>(EventImpl.class);
    private EventService eventService;

    public EventResourceImpl(EventResourceComponent record, EventServiceComponent eventService) {
        super(record);
        this.eventService = eventService;
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
                "TicketingSystem.event.rating.model.EventImpl",
                id, name, date, location, description);
        eventratingRepository.saveObject(event);

        return event.toHashMap();
    }

    public HashMap<String, Object> Event(VMJExchange vmjExchange) {
        return new HashMap<>(); // implement if needed
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
