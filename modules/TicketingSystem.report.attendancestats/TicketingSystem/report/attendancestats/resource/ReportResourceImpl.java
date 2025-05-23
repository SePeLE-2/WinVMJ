package TicketingSystem.report.attendancestats;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportResourceDecorator;
import TicketingSystem.report.core.ReportResourceComponent;
import TicketingSystem.report.core.Report;
import vmj.hibernate.integrator.RepositoryUtil;
import TicketingSystem.event.core.EventImpl;
import TicketingSystem.report.attendancestats.ReportImpl;

public class ReportResourceImpl extends ReportResourceDecorator {
    private RepositoryUtil<Report> repository = new RepositoryUtil<>(TicketingSystem.report.core.ReportComponent.class);

    public ReportResourceImpl (ReportResourceComponent record) {
        super(record);
    }

    @Route(url="call/attendancestats/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        ReportImpl report = createReportAttendanceStats(vmjExchange);
        repository.saveObject(report);
        return getAllReportAttendanceStats(vmjExchange);
    }

    public ReportImpl createReportAttendanceStats(VMJExchange vmjExchange){
        int showingAttendance = Integer.parseInt((String) vmjExchange.getRequestBodyForm("showingAttendance"));
        int attendancePercentage = Integer.parseInt((String) vmjExchange.getRequestBodyForm("attendancePercentage"));
        ReportImpl report = new ReportImpl();
        report.setShowingAttendance(showingAttendance);
        report.attendancePercentage = attendancePercentage;
        return report;
    }

    public ReportImpl createReportAttendanceStats(VMJExchange vmjExchange, int id){
        int showingAttendance = Integer.parseInt((String) vmjExchange.getRequestBodyForm("showingAttendance"));
        int attendancePercentage = Integer.parseInt((String) vmjExchange.getRequestBodyForm("attendancePercentage"));
        ReportImpl report = new ReportImpl();
        report.setShowingAttendance(showingAttendance);
        report.attendancePercentage = attendancePercentage;
        return report;
    }

    @Route(url="call/attendancestats/update")
    public HashMap<String, Object> updateReportAttendanceStats(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        String idStr = (String) vmjExchange.getRequestBodyForm("idReport");
        int id = Integer.parseInt(idStr);
        ReportImpl report = createReportAttendanceStats(vmjExchange, id);
        repository.updateObject(report);
        return report.toHashMap();
    }

    @Route(url="call/attendancestats/get")
    public HashMap<String, Object> getReportAttendanceStats(VMJExchange vmjExchange) {
        String idStr = (String) vmjExchange.getRequestBodyForm("id");
        UUID id = UUID.fromString(idStr);
        Report report = repository.getObject(id);
        if (report instanceof ReportImpl) {
            return ((ReportImpl) report).toHashMap();
        }
        return null;
    }

    @Route(url="call/attendancestats/getall")
    public List<HashMap<String, Object>> getAllReportAttendanceStats(VMJExchange vmjExchange) {
        List<Report> reports = repository.getAllObject("report_attendancestats");
        List<HashMap<String, Object>> result = new ArrayList<>();
        for (Report report : reports) {
            if (report instanceof ReportImpl) {
                result.add(((ReportImpl) report).toHashMap());
            }
        }
        return result;
    }

    @Route(url="call/attendancestats/delete")
    public List<HashMap<String,Object>> deleteReportAttendanceStats(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        String idStr = (String) vmjExchange.getRequestBodyForm("idReport");
        int id = Integer.parseInt(idStr);
        repository.deleteObject(id);
        return getAllReportAttendanceStats(vmjExchange);
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
}
