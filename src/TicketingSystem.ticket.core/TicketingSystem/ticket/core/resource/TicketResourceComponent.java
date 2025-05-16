package TicketingSystem.ticket.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TicketResourceComponent implements TicketResource {
    protected RepositoryUtil<Ticket> ticketRepository;

    public TicketResourceComponent() {
        this.ticketRepository = new RepositoryUtil<Ticket>(TicketingSystem.ticket.core.TicketComponent.class);
    }

    public abstract HashMap<String, Object> saveTicket(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> updateTicket(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> getTicket(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> getAllTicket(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> deleteTicket(VMJExchange vmjExchange);

    public abstract void purchase();
}
