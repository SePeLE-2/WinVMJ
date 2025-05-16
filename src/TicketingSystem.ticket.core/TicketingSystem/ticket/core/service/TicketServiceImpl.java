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
	public Ticket saveTicket(HashMap<String, Object> body, String email) {
		if (!body.containsKey("eventName")) {
			throw new FieldValidationException("Field 'eventName' not found in the request body.");
		}
		String eventName = (String) body.get("eventName");

		if (!body.containsKey("ticketName")) {
			throw new FieldValidationException("Field 'ticketName' not found in the request body.");
		}
		String ticketName = (String) body.get("ticketName");

		if (!body.containsKey("price")) {
			throw new FieldValidationException("Field 'price' not found in the request body.");
		}
		String priceStr = (String) body.get("price");
		int price = Integer.parseInt(priceStr);

		if (!body.containsKey("availability")) {
			throw new FieldValidationException("Field 'availability' not found in the request body.");
		}
		String availabilityStr = (String) body.get("availability");
		int availability = Integer.parseInt(availabilityStr);

		UUID ticketId = UUID.randomUUID();

		Ticket ticket = TicketFactory.createTicket("TicketingSystem.ticket.core.TicketImpl",
				ticketId,
				eventName,
				ticketName,
				price, availability);
		ticketRepository.saveObject(ticket);
		return ticketRepository.getObject(ticketId);
	}

	public Ticket updateTicket(HashMap<String, Object> body) {
		if (!body.containsKey("id")) {
			throw new NotFoundException("Field 'id' not found in the request body.");
		}
		String idStr = (String) body.get("id");
		UUID id = UUID.fromString(idStr);

		Ticket ticket = ticketRepository.getObject(id);
		if (ticket == null) {
			throw new NotFoundException("Ticket with id " + id + " not found");
		}

		if (body.containsKey("eventName")) {
			String eventName = (String) body.get("eventName");
			ticket.setEventName(eventName);
		}
		if (body.containsKey("ticketName")) {
			String ticketName = (String) body.get("ticketName");
			ticket.setTicketName(ticketName);
		}

		int price = -1;
		if (body.containsKey("price")) {
			try {
				price = Integer.parseInt((String) body.get("price"));
			} catch (NumberFormatException e) {
				throw new FieldValidationException("Price must be an integer");
			}
		}

		if (price != -1) {
			ticket.setPrice(price);
		}

		int availability = -1;
		if (body.containsKey("availability")) {
			try {
				availability = Integer.parseInt((String) body.get("availability"));
			} catch (NumberFormatException e) {
				throw new FieldValidationException("Availability must be an integer");
			}
		}
		if (availability != -1) {
			ticket.setAvailability(availability);
		}

		ticketRepository.updateObject(ticket);
		ticket = ticketRepository.getObject(id);

		return ticket;
	}

	public Ticket getTicket(UUID Id) {
		Ticket ticket = ticketRepository.getObject(Id);
		if (ticket == null) {
			throw new NotFoundException("Ticket with Id " + Id + " not found");
		}
		return ticket;
	}

	public List<Ticket> getAllTicket() {
		List<Ticket> ticketList = ticketRepository.getListObject("ticket_impl", null, null);
		Set<String> uniqueNames = new HashSet<>();
		List<Ticket> uniqueTickets = new ArrayList<>();
		for (Ticket ticket : ticketList) {
			if (uniqueNames.add(ticket.getEventName())) {
				uniqueTickets.add(ticket);
			}
		}
		return uniqueTickets;
	}

	public List<Ticket> deleteTicket(UUID Id) {
		Ticket ticket = ticketRepository.getObject(Id);
		// TODO: delete ticket
		return getAllTicket();
	}

	public List<HashMap<String, Object>> transformTicketListToHashMap(List<Ticket> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public void purchase() {
		// TODO: implement this method
	}
}
