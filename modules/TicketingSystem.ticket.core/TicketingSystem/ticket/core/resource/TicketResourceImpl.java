package TicketingSystem.ticket.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.ticket.TicketFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class TicketResourceImpl extends TicketResourceComponent{
	
	private TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/ticket/save")
    public List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Ticket ticket = createTicket(vmjExchange);
		ticketRepository.saveObject(ticket);
		return getAllTicket(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/ticket")
    public HashMap<String,Object> ticket(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Ticket result = ticketServiceImpl.createTicket(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Ticket createTicket(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Ticket result = ticketServiceImpl.createTicket(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Ticket createTicket(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Ticket result = ticketServiceImpl.createTicket(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/ticket/update")
    public HashMap<String, Object> updateTicket(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return ticketServiceImpl.updateTicket(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/ticket/detail")
    public HashMap<String, Object> getTicket(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ticketServiceImpl.getTicket(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/ticket/list")
    public List<HashMap<String,Object>> getAllTicket(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return ticketServiceImpl.getAllTicket(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/ticket/delete")
    public List<HashMap<String,Object>> deleteTicket(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return ticketServiceImpl.deleteTicket(requestBody);
	}


	
	public void purchase() {
		// TODO: implement this method
	}
}
