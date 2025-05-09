package TicketingSystem.event.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Event {
	HashMap<String, Object> toHashMap();

	public UUID getIdEvent();

	public void setIdEvent(UUID idEvent);

	public String getName();

	public void setName(String name);

	public String getDate();

	public void setDate(String date);

	public String getLocation();

	public void setLocation(String location);

	public String getDescription();

	public void setDescription(String description);
}
