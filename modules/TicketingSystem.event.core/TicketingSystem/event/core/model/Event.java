package TicketingSystem.event.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Event {
	HashMap<String, Object> toHashMap();
}
