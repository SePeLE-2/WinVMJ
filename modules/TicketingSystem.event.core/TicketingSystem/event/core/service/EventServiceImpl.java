package TicketingSystem.event.core;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.event.EventFactory;
import vmj.auth.annotations.Restricted;
//add other required packages
import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

public class EventServiceImpl extends EventServiceComponent {

	@Override
	public List<HashMap<String, Object>> saveEvent(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		// Event event = createEvent(vmjExchange);

		Map<String, Object> requestBody = vmjExchange.getPayload();
		Event event = createEvent(requestBody);

		// eventRepository.saveObject(event);
		Repository.saveObject(event);
		return getAllEvent(requestBody);
	}

	public Event createEvent(Map<String, Object> requestBody) {
		String idEventStr = (String) requestBody.get("idEvent");
		int idEvent = Integer.parseInt(idEventStr);
		String name = (String) requestBody.get("name");
		String date = (String) requestBody.get("date");
		String location = (String) requestBody.get("location");
		String description = (String) requestBody.get("description");

		// to do: fix association attributes
		TicketImpl dummyTicketImpl = new TicketImpl();
		BundlingImpl dummyBundlingImpl = new BundlingImpl();

		Event Event = EventFactory.createEvent(
				"TicketingSystem.event.core.EventImpl",
				idEvent, name, date, location, description, dummyTicketImpl, dummyBundlingImpl);
		Repository.saveObject(Event);
		return Event;
	}

	public Event createEvent(Map<String, Object> requestBody, Map<String, Object> response) {
		return createEvent(requestBody);
	}

	// public Event createEvent(Map<String, Object> requestBody, int id) {
	// String name = (String) vmjExchange.getRequestBodyForm("name");
	// String date = (String) vmjExchange.getRequestBodyForm("date");
	// String location = (String) vmjExchange.getRequestBodyForm("location");
	// String description = (String) vmjExchange.getRequestBodyForm("description");

	// // to do: fix association attributes
	// TicketImpl dummyTicketImpl = new TicketImpl();
	// BundlingImpl dummyBundlingImpl = new BundlingImpl();

	// Event event =
	// EventFactory.createEvent("TicketingSystem.event.core.EventImpl", name, date,
	// location,
	// description, dummyTicketImpl, dummyBundlingImpl);
	// return event;
	// }

	public HashMap<String, Object> updateEvent(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("idEvent");
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);
		Event event = Repository.getObject(id);

		event.setName((String) requestBody.get("name"));
		event.setDate((String) requestBody.get("date"));
		event.setLocation((String) requestBody.get("location"));
		event.setDescription((String) requestBody.get("description"));

		Repository.updateObject(event);

		// to do: fix association attributes

		return event.toHashMap();

	}

	public HashMap<String, Object> getEvent(Map<String, Object> requestBody) {
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "event_impl");
		List<HashMap<String, Object>> eventList = getAllEvent(map);
		for (HashMap<String, Object> event : eventList) {
			int record_id = ((Double) event.get("record_id")).intValue();
			if (event.get("id").equals(record_id)) {
				return event;
			}
		}
		return null;
	}

	public HashMap<String, Object> getEventById(int id) {
		// String idStr = vmjExchange.getGETParam("idEvent");
		// int id = Integer.parseInt(idStr);
		// Event event = eventRepository.getObject(id);
		// return event.toHashMap();

		// You declared UUID id before, but abstract method still uses int
		// Here we assume int → UUID mapping is handled elsewhere or refactor later
		throw new UnsupportedOperationException("getBundlingById(int) not implemented. Use UUID instead.");
	}

	public List<HashMap<String, Object>> getAllEvent(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Event> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Event> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteEvent(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllEvent(requestBody);
	}

	public void createEvent() {
		// TODO: implement this method
		System.out.println("createEvent() called in service; this should ideally be in entity logic.");
	}

	public String getDetails() {
		// TODO: implement this method
		System.out.println("getDetails() called in service; this should ideally be in entity logic.");
		return "getDetails() called in service; this should ideally be in entity logic.";
	}
}
