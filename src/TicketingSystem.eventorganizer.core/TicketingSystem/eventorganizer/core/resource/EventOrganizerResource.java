package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EventOrganizerResource {
    List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange);
    HashMap<String, Object> updateEventOrganizer(VMJExchange vmjExchange);
    HashMap<String, Object> getEventOrganizer(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllEventOrganizer(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteEventOrganizer(VMJExchange vmjExchange);
	HashMap<String, Object> EventOrganizer(VMJExchange vmjExhange);
}
