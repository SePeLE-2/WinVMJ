package TicketingSystem.report.attendancestats;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import TicketingSystem.report.core.ReportServiceDecorator;
import TicketingSystem.report.core.ReportServiceComponent;
import TicketingSystem.report.core.Report;
import TicketingSystem.report.attendancestats.ReportImpl;

public class ReportServiceImpl extends ReportServiceDecorator {
    private RepositoryUtil<Report> repository = new RepositoryUtil<>(TicketingSystem.report.core.ReportComponent.class);

    public ReportServiceImpl(ReportServiceComponent record) {
        super(record);
    }

    public void calculateAttendancePercentage() {
        List<Report> reports = repository.getAllObject("report_attendancestats");
        for (Report report : reports) {
            if (report instanceof ReportImpl) {
                ReportImpl attendanceReport = (ReportImpl) report;
                attendanceReport.calculateAttendancePercentage();
                repository.updateObject(attendanceReport);
            }
        }
    }

    @Override
    public List<HashMap<String, Object>> saveReport(Map<String, Object> requestBody) {
        ReportImpl report = new ReportImpl();
        report.setShowingAttendance((int) requestBody.get("showingAttendance"));
        report.attendancePercentage = (int) requestBody.get("attendancePercentage");
        repository.saveObject(report);
        return getAllReport(requestBody);
    }

    @Override
    public HashMap<String, Object> getReportById(int id) {
        throw new UnsupportedOperationException("Use UUID instead of int for report ID.");
    }
}
