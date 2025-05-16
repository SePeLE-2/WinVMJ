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
	public Event saveEvent(HashMap<String, Object> body, String email) {
		if (!body.containsKey("name")) {
			throw new FieldValidationException("Field 'name' not found in the request body.");
		}
		String name = (String) body.get("name");

		if (!body.containsKey("date")) {
			throw new FieldValidationException("Field 'date' not found in the request body.");
		}
		String date = (String) body.get("date");

		if (!body.containsKey("location")) {
			throw new FieldValidationException("Field 'location' not found in the request body.");
		}
		String location = (String) body.get("location");

		if (!body.containsKey("description")) {
			throw new FieldValidationException("Field 'description' not found in the request body.");
		}
		String description = (String) body.get("description");

		UUID id = UUID.randomUUID();

		Event event = EventFactory.createEvent("TicketingSystem.event.core.EventImpl",
				id,
				name,
				date,
				location,
				description);
		eventRepository.saveObject(event);
		return eventRepository.getObject(id);
	}

	// public Event createEvent(Map<String, Object> requestBody) {
	// String idEventStr = (String) requestBody.get("idEvent");
	// int idEvent = Integer.parseInt(idEventStr);
	// String name = (String) requestBody.get("name");
	// String date = (String) requestBody.get("date");
	// String location = (String) requestBody.get("location");
	// String description = (String) requestBody.get("description");

	// // to do: fix association attributes
	// TicketImpl dummyTicketImpl = new TicketImpl();
	// BundlingImpl dummyBundlingImpl = new BundlingImpl();

	// Event Event = EventFactory.createEvent(
	// "TicketingSystem.event.core.EventImpl",
	// idEvent, name, date, location, description, dummyTicketImpl,
	// dummyBundlingImpl);
	// Repository.saveObject(Event);
	// return Event;
	// }

	// public Event createEvent(Map<String, Object> requestBody, Map<String, Object>
	// response) {
	// return createEvent(requestBody);
	// }

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

	public Event updateEvent(Map<String, Object> body) {
		if (!body.containsKey("idEvent")) {
			throw new NotFoundException("Field 'idEvent' not found in the request body.");
		}
		String idStr = (String) body.get("idEvent");
		UUID id = UUID.fromString(idStr);

		Event event = eventRepository.getObject(id);
		if (event == null) {
			throw new NotFoundException("Event with id " + id + " not found");
		}

		if (body.containsKey("name")) {
			String name = (String) body.get("name");
			event.setName(name);
		}

		if (body.containsKey("date")) {
			String date = (String) body.get("date");
			event.setDate(date);
		}

		if (body.containsKey("location")) {
			String location = (String) body.get("location");
			event.setLocation(location);
		}

		if (body.containsKey("description")) {
			String description = (String) body.get("description");
			event.setDescription(description);
		}

		eventRepository.updateObject(event);
		event = eventRepository.getObject(id);

		return event;
	}

	public Event getEvent(UUID Id) {
		Event event = eventRepository.getObject(Id);
		if (event == null) {
			throw new NotFoundException("Event with Id " + Id + " not found");
		}
		return event;
	}

	// public HashMap<String, Object> getEventById(int id) {
	// // String idStr = vmjExchange.getGETParam("idEvent");
	// // int id = Integer.parseInt(idStr);
	// // Event event = eventRepository.getObject(id);
	// // return event.toHashMap();

	// // You declared UUID id before, but abstract method still uses int
	// // Here we assume int → UUID mapping is handled elsewhere or refactor later
	// throw new UnsupportedOperationException("getBundlingById(int) not
	// implemented. Use UUID instead.");
	// }

	public List<Event> getAllEvent() {
		List<Event> resultList = eventRepository.getListObject("event_impl", null, null);
		Set<String> uniqueNames = new HashSet<>();
		List<Event> uniqueEvents = new ArrayList<>();
		for (Event event : resultList) {
			if (uniqueNames.add(event.getName())) {
				uniqueEvents.add(event);
			}
		}
		return uniqueEvents;
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Event> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<Event> deleteEvent(UUID Id) {
		Event event = eventRepository.getObject(Id);
		// TODO: delete ticket
		return getAllEvent();
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
