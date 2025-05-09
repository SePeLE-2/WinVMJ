package TicketingSystem.ticket.core;

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
import TicketingSystem.ticket.TicketFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class TicketServiceImpl extends TicketServiceComponent {
	private TicketFactory ticketFactory = new TicketFactory();

	// public List<HashMap<String, Object>> saveTicket(VMJExchange vmjExchange) {
	// if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// return null;
	// }
	// Ticket ticket = createTicket(vmjExchange);
	// ticketRepository.saveObject(ticket);
	// return getAllTicket(vmjExchange);
	// }

	public List<HashMap<String, Object>> saveTicket(Map<String, Object> requestBody) {
		String eventName = (String) requestBody.get("eventName");
		String ticketName = (String) requestBody.get("ticketName");
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String availabilityStr = (String) requestBody.get("availability");
		int availability = Integer.parseInt(availabilityStr);

		Ticket Ticket = TicketFactory.createTicket(
				"TicketingSystem.ticket.core.TicketImpl",
				eventName, ticketName, price, availability);
		Repository.saveObject(Ticket);
		return getAllTicket(requestBody);
	}

	public Ticket createTicket(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String eventName = (String) requestBody.get("eventName");
		String ticketName = (String) requestBody.get("ticketName");
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String availabilityStr = (String) requestBody.get("availability");
		int availability = Integer.parseInt(availabilityStr);

		// to do: fix association attributes
		Ticket Ticket = TicketFactory.createTicket(
				"TicketingSystem.ticket.core.TicketImpl",
				id, eventName, ticketName, price, availability);
		Repository.saveObject(Ticket);
		return Ticket;
	}

	// public Ticket createTicket(Map<String, Object> requestBody, int id) {
	// String eventName = (String) vmjExchange.getRequestBodyForm("eventName");
	// String ticketName = (String) vmjExchange.getRequestBodyForm("ticketName");
	// String priceStr = (String) vmjExchange.getRequestBodyForm("price");
	// int price = Integer.parseInt(priceStr);
	// String availabilityStr = (String)
	// vmjExchange.getRequestBodyForm("availability");
	// int availability = Integer.parseInt(availabilityStr);

	// // to do: fix association attributes

	// Ticket ticket =
	// TicketFactory.createTicket("TicketingSystem.ticket.core.TicketImpl",
	// eventName, ticketName,
	// price, availability);
	// return ticket;
	// }

	public HashMap<String, Object> updateTicket(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);
		Ticket ticket = Repository.getObject(id);

		ticket.setEventName((String) requestBody.get("eventName"));
		ticket.setTicketName((String) requestBody.get("ticketName"));
		String priceStr = (String) requestBody.get("price");
		ticket.setPrice(Integer.parseInt(priceStr));
		String availabilityStr = (String) requestBody.get("availability");
		ticket.setAvailability(Integer.parseInt(availabilityStr));

		Repository.updateObject(ticket);

		// to do: fix association attributes

		return ticket.toHashMap();

	}

	public HashMap<String, Object> getTicket(Map<String, Object> requestBody) {
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "ticket_impl");
		List<HashMap<String, Object>> ticketList = getAllTicket(map);
		for (HashMap<String, Object> ticket : ticketList) {
			UUID record_id = UUID.fromString(ticket.get("record_id").toString());
			String idStr = (String) requestBody.get("record_id");
			UUID id = UUID.fromString(idStr);
			if (record_id.equals(id)) {
				return ticket;
			}
		}
		return null;
	}

	public HashMap<String, Object> getTicketById(int id) {
		Ticket ticket = Repository.getObject(id);
		return ticket.toHashMap();
	}

	public List<HashMap<String, Object>> getAllTicket(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Ticket> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Ticket> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteTicket(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllTicket(requestBody);
	}

	public void purchase() {
		// TODO: implement this method
	}
}
