package TicketingSystem.report.attendancestats;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportServiceDecorator;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportServiceComponent;

public class ReportServiceImpl extends ReportServiceDecorator {
    public ReportServiceImpl (ReportServiceComponent record) {
        super(record);
    }

    
	public void calculateAttendancePercentage() {
		// TODO: implement this method
	}
}
