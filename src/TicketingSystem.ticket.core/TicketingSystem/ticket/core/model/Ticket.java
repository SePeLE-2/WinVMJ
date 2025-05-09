package TicketingSystem.ticket.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Ticket {
	HashMap<String, Object> toHashMap();

	public UUID getId();

	public void setId(UUID id);

	public String getEventName();

	public void setEventName(String eventName);

	public String getTicketName();

	public void setTicketName(String ticketName);

	public int getPrice();

	public void setPrice(int price);

	public int getAvailability();

	public void setAvailability(int availability);
}
