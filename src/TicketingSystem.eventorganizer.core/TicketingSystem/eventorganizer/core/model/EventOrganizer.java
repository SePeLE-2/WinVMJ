package TicketingSystem.eventorganizer.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface EventOrganizer {
	HashMap<String, Object> toHashMap();
	void setId(UUID id);
	void setName(String name);
	void setEmail(String email);
	void setLocation(String location);
}
