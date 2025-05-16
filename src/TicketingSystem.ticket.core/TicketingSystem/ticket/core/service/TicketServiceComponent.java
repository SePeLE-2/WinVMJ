package TicketingSystem.ticket.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TicketServiceComponent implements TicketService {
    protected RepositoryUtil<Ticket> ticketRepository;

    public TicketServiceComponent() {
        this.ticketRepository = new RepositoryUtil<Ticket>(TicketingSystem.ticket.core.TicketComponent.class);
    }

    public abstract Ticket saveTicket(HashMap<String, Object> body, String email);

    public abstract Ticket updateTicket(HashMap<String, Object> body);

    public abstract Ticket getTicket(UUID Id);

    public abstract List<Ticket> getAllTicket();

    public abstract List<Ticket> deleteTicket(UUID Id);

    public abstract List<HashMap<String, Object>> transformTicketListToHashMap(List<Ticket> List);

    public abstract void purchase();
}
