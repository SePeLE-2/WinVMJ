package TicketingSystem.ticket.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.ticket.TicketFactory;
import TicketingSystem.ticket.core.TicketService;
import vmj.auth.annotations.Restricted;
//add other required packages

public class TicketResourceImpl extends TicketResourceComponent {

	private TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();

	// @Restriced(permission = "")
	@Route(url = "call/ticket/save")
	public HashMap<String, Object> saveTicket(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Ticket ticket = ticketServiceImpl.saveTicket((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return ticket.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/ticket/update")
	public HashMap<String, Object> updateTicket(VMJExchange vmjExchange) {
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return ticketServiceImpl.updateTicket(requestBody).toHashMap();

	}

	// @Restriced(permission = "")
	@Route(url = "call/ticket/detail")
	public HashMap<String, Object> getTicket(VMJExchange vmjExchange) {
		String ticketIdStr = vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(ticketIdStr);
		return ticketServiceImpl.getTicket(id).toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/ticket/list")
	public List<HashMap<String, Object>> getAllTicket(VMJExchange vmjExchange) {
		List<Ticket> ticketList = ticketServiceImpl.getAllTicket();
		return ticketServiceImpl.transformTicketListToHashMap(ticketList);
	}

	// @Restriced(permission = "")
	@Route(url = "call/ticket/delete")
	public List<HashMap<String, Object>> deleteTicket(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		String ticketIdStr = (String) body.get("id");
		UUID id = UUID.fromString(ticketIdStr);
		Ticket ticket = ticketRepository.getObject(id);
		List<Ticket> ticketList = ticketServiceImpl.deleteTicket(id);
		return ticketServiceImpl.transformTicketListToHashMap(ticketList);
	}

	public void purchase() {
		// TODO: implement this method
	}
}
