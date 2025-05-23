package TicketingSystem.report.attendancestats;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportServiceDecorator;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportServiceComponent;
import TicketingSystem.report.core.Repository;
import TicketingSystem.report.core.Report;

public class ReportServiceImpl extends ReportServiceDecorator {
    public ReportServiceImpl (ReportServiceComponent record) {
        super(record);
    }

    
	public void calculateAttendancePercentage() {
		List<Report> reports = Repository.getAllObject("report_attendancestats");
		for (Report report : reports) {
			if (report instanceof ReportImpl) {
				ReportImpl attendanceReport = (ReportImpl) report;
				attendanceReport.calculateAttendancePercentage();
				Repository.updateObject(attendanceReport);
			}
		}
	}
}
