package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EventOrganizerService {
	EventOrganizer createEventOrganizer(Map<String, Object> requestBody);
	EventOrganizer createEventOrganizer(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getEventOrganizer(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveEventOrganizer(Map<String, Object> requestBody);
    HashMap<String, Object> updateEventOrganizer(Map<String, Object> requestBody);
    HashMap<String, Object> getEventOrganizerById(int id);
    List<HashMap<String,Object>> getAllEventOrganizer(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteEventOrganizer(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
