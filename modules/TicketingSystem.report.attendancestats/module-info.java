module TicketingSystem.report.attendancestats {
	requires TicketingSystem.report.core;
    exports TicketingSystem.report.attendancestats;
    
	requires java.logging;
	requires java.naming;
	requires java.net.http;
	requires java.sql;
}
