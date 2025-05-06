package TicketingSystem.ticket.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TicketService {
	Ticket createTicket(Map<String, Object> requestBody);
	Ticket createTicket(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getTicket(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveTicket(Map<String, Object> requestBody);
    HashMap<String, Object> updateTicket(Map<String, Object> requestBody);
    HashMap<String, Object> getTicketById(int id);
    List<HashMap<String,Object>> getAllTicket(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteTicket(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
