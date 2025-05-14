package TicketingSystem.bundling.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Bundling {
	HashMap<String, Object> toHashMap();

	public UUID getId();

	public void setId(UUID id);

	public String getBundlingName();

	public void setBundlingName(String bundlingName);

	public int getPrice();

	public void setPrice(int price);

	public int getAvailability();

	public void setAvailability(int availability);
}
