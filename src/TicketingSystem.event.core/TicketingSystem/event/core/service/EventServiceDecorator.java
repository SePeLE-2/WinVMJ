package TicketingSystem.event.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class EventServiceDecorator extends EventServiceComponent {
	protected EventServiceComponent record;

	public EventServiceDecorator(EventServiceComponent record) {
		this.record = record;
	}

	// public Event createEvent(Map<String, Object> requestBody) {
	// return record.createEvent(requestBody);
	// }

	// public Event createEvent(Map<String, Object> requestBody, Map<String, Object>
	// response) {
	// return record.createEvent(requestBody, response);
	// }

	public Event getEvent(UUID id) {
		return record.getEvent(id);
	}

	public List<Event> getAllEvent() {
		return record.getAllEvent();
	}

	public Event saveEvent(HashMap<String, Object> body, String email) {
		return record.saveEvent(body, email);
	}

	public Event updateEvent(Map<String, Object> requestBody) {
		return record.updateEvent(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Event> List) {
		return record.transformListToHashMap(List);
	}

	public List<Event> deleteEvent(UUID Id) {
		return record.deleteEvent(Id);
	}

	// public Event getEventById(UUID id) {
	// return record.getEventById(id);
	// }

	public void createEvent() {
		record.createEvent();
	}

	public String getDetails() {
		return record.getDetails();
	}
}
