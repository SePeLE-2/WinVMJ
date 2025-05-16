package TicketingSystem.event.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EventService {
    // Event createEvent(Map<String, Object> requestBody);

    // Event createEvent(Map<String, Object> requestBody, Map<String, Object>
    // response);

    Event getEvent(UUID Id);

    // List<HashMap<String,Object>> saveEvent(Map<String, Object> requestBody);
    Event saveEvent(HashMap<String, Object> body, String email);

    Event updateEvent(Map<String, Object> requestBody);

    // Event getEventById(UUID Id);

    List<Event> getAllEvent();

    List<Event> deleteEvent(UUID Id);

    List<HashMap<String, Object>> transformListToHashMap(List<Event> List);

    void createEvent();

    String getDetails();
}
