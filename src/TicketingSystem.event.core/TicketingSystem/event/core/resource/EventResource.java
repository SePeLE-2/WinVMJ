package TicketingSystem.event.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface EventResource {
    List<HashMap<String,Object>> saveEvent(VMJExchange vmjExchange);
    HashMap<String, Object> updateEvent(VMJExchange vmjExchange);
    HashMap<String, Object> getEvent(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllEvent(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteEvent(VMJExchange vmjExchange);
	HashMap<String, Object> Event(VMJExchange vmjExhange);
}
