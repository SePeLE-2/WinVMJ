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
	public List<HashMap<String, Object>> saveEvent(VMJExchange vmjExchange) {
		eventServiceImpl.saveEvent(vmjExchange);
		return getAllEvent(vmjExchange);
		// if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
		// return null;
		// }
		// Event event = createEvent(vmjExchange);
		// Repository.saveObject(event);
		// return getAllEvent(vmjExchange);
	}

	@Route(url = "call/event")
	@Override
	public HashMap<String, Object> Event(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			Event event = eventServiceImpl.createEvent(requestBody);
			return event.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Route(url = "call/event")
	public HashMap<String, Object> event(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			Event result = eventServiceImpl.createEvent(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	public Event createEvent(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			Event result = eventServiceImpl.createEvent(requestBody);
			// return result.toHashMap();
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	public Event createEvent(VMJExchange vmjExchange, int id) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			// Event result = eventServiceImpl.createEvent(requestBody, id);
			Event result = eventServiceImpl.createEvent(requestBody);
			// return result.toHashMap();
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Route(url = "call/event/update")
	public HashMap<String, Object> updateEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return eventServiceImpl.updateEvent(requestBody);

	}

	@Route(url = "call/event/detail")
	public HashMap<String, Object> getEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return eventServiceImpl.getEvent(requestBody);
	}

	@Route(url = "call/event/list")
	public List<HashMap<String, Object>> getAllEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return eventServiceImpl.getAllEvent(requestBody);
	}

	@Route(url = "call/event/delete")
	public List<HashMap<String, Object>> deleteEvent(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		return eventServiceImpl.deleteEvent(requestBody);
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
