module TicketingSystem.report.attendancestats {
	requires TicketingSystem.report.core;
	requires vmj.routing.route;
	requires java.persistence;
	requires vmj.hibernate.integrator;
	requires TicketingSystem.event.core;
	exports TicketingSystem.report.attendancestats;
	
	requires java.logging;
	requires java.naming;
	requires java.net.http;
	requires java.sql;
}
