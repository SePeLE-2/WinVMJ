module ticketingsystem.product.default {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires TicketingSystem.event.core;
    requires TicketingSystem.eventorganizer.core;
    requires TicketingSystem.payment.core;
    requires TicketingSystem.payment.creditcard;
    requires TicketingSystem.ticket.core;
    requires TicketingSystem.report.salesreport;

}