package TicketingSystem.event.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EventService {
	Event createEvent(Map<String, Object> requestBody);
	Event createEvent(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getEvent(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveEvent(Map<String, Object> requestBody);
    HashMap<String, Object> updateEvent(Map<String, Object> requestBody);
    HashMap<String, Object> getEventById(int id);
    List<HashMap<String,Object>> getAllEvent(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteEvent(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
