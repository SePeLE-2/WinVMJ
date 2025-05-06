package TicketingSystem.ticket.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TicketResource {
    List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange);
    HashMap<String, Object> updateTicket(VMJExchange vmjExchange);
    HashMap<String, Object> getTicket(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTicket(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteTicket(VMJExchange vmjExchange);
	HashMap<String, Object> Ticket(VMJExchange vmjExhange);
}
