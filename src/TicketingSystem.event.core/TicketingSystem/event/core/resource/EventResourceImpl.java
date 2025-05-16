package TicketingSystem.event.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.event.EventFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class EventResourceImpl extends EventResourceComponent {

	private EventServiceImpl eventServiceImpl = new EventServiceImpl();

	@Route(url = "call/event/save")
	public HashMap<String, Object> saveEvent(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Event event = eventServiceImpl.saveEvent((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return event.toHashMap();
	}

	@Route(url = "call/event")
	@Override
	public HashMap<String, Object> Event(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Event event = eventServiceImpl.saveEvent((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return event.toHashMap();
	}

	// @Route(url = "call/event")
	// public HashMap<String, Object> event(VMJExchange vmjExchange) {
	// if (vmjExchange.getHttpMethod().equals("POST")) {
	// Map<String, Object> requestBody = vmjExchange.getPayload();
	// Event result = eventServiceImpl.createEvent(requestBody);
	// return result.toHashMap();
	// }
	// throw new NotFoundException("Route tidak ditemukan");
	// }

	// public Event createEvent(VMJExchange vmjExchange) {
	// if (vmjExchange.getHttpMethod().equals("POST")) {
	// Map<String, Object> requestBody = vmjExchange.getPayload();
	// Event result = eventServiceImpl.createEvent(requestBody);
	// // return result.toHashMap();
	// return result;
	// }
	// throw new NotFoundException("Route tidak ditemukan");
	// }

	// public Event createEvent(VMJExchange vmjExchange, int id) {
	// if (vmjExchange.getHttpMethod().equals("POST")) {
	// Map<String, Object> requestBody = vmjExchange.getPayload();
	// // Event result = eventServiceImpl.createEvent(requestBody, id);
	// Event result = eventServiceImpl.createEvent(requestBody);
	// // return result.toHashMap();
	// return result;
	// }
	// throw new NotFoundException("Route tidak ditemukan");
	// }

	@Route(url = "call/event/update")
	public HashMap<String, Object> updateEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return eventServiceImpl.updateEvent(requestBody).toHashMap();
	}

	@Route(url = "call/event/detail")
	public HashMap<String, Object> getEvent(VMJExchange vmjExchange) {
		String idStr = vmjExchange.getGETParam("idEvent");
		UUID id = UUID.fromString(idStr);
		return eventServiceImpl.getEvent(id).toHashMap();
	}

	@Route(url = "call/event/list")
	public List<HashMap<String, Object>> getAllEvent(VMJExchange vmjExchange) {
		List<Event> List = eventServiceImpl.getAllEvent();
		return eventServiceImpl.transformListToHashMap(List);
	}

	@Route(url = "call/event/delete")
	public List<HashMap<String, Object>> deleteEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		String idStr = (String) body.get("idEvent");
		UUID id = UUID.fromString(idStr);
		Event event = eventRepository.getObject(id);
		List<Event> List = eventServiceImpl.deleteEvent(id);
		return eventServiceImpl.transformListToHashMap(List);
	}

	public void createEvent() {
		// TODO: implement this method
		System.out.println("createEvent() called in service; this should ideally be in entity logic.");
	}

	public String getDetails() {
		return "{" +
				" idEvent='" + "'" +
				" name='" + "'" +
				" date='" + "'" +
				" location='" + "'" +
				" description='" + "'" +
				" ticketimpl='" + "'" +
				" bundlingimpl='" + "'" +
				"}";
	}
}
