package TicketingSystem.ticket.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TicketService {
    Ticket saveTicket(HashMap<String, Object> body, String email);

    Ticket updateTicket(HashMap<String, Object> body);

    Ticket getTicket(UUID Id);

    List<Ticket> getAllTicket();

    List<Ticket> deleteTicket(UUID Id);

    List<HashMap<String, Object>> transformTicketListToHashMap(List<Ticket> List);

    void purchase();
}
