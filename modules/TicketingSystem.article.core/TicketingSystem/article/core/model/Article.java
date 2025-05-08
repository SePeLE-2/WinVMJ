package TicketingSystem.article.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Article {
	public void publish();
	HashMap<String, Object> toHashMap();
}
