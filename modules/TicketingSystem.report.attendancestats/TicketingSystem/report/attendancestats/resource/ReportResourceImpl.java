package TicketingSystem.report.attendancestats;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportResourceDecorator;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportResourceComponent;

public class ReportResourceImpl extends ReportResourceDecorator {
    public ReportResourceImpl (ReportResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/attendancestats/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReportAttendanceStats reportattendancestats = createReportAttendanceStats(vmjExchange);
		reportattendancestatsRepository.saveObject(reportattendancestats);
		return getAllReportAttendanceStats(vmjExchange);
	}

    public Report createReportAttendanceStats(VMJExchange vmjExchange){
		String showingAttendanceStr = (String) vmjExchange.getRequestBodyForm("showingAttendance");
		int showingAttendance = Integer.parseInt(showingAttendanceStr);
		String attendancePercentageStr = (String) vmjExchange.getRequestBodyForm("attendancePercentage");
		int attendancePercentage = Integer.parseInt(attendancePercentageStr);
		
		ReportAttendanceStats reportattendancestats = record.createReportAttendanceStats(vmjExchange);
		ReportAttendanceStats reportattendancestatsdeco = ReportAttendanceStatsFactory.createReportAttendanceStats("TicketingSystem.attendancestats.core.ReportImpl", reportattendancestats, idReport, idEvent, eventName, eventDate, reportDate, ticketSold, eventimpl
		showingAttendance, attendancePercentage
		);
			return reportattendancestatsdeco;
	}


    public Report createReportAttendanceStats(VMJExchange vmjExchange, int id){
		String showingAttendanceStr = (String) vmjExchange.getRequestBodyForm("showingAttendance");
		int showingAttendance = Integer.parseInt(showingAttendanceStr);
		String attendancePercentageStr = (String) vmjExchange.getRequestBodyForm("attendancePercentage");
		int attendancePercentage = Integer.parseInt(attendancePercentageStr);
		ReportAttendanceStats reportattendancestats = reportattendancestatsRepository.getObject(id);
		int recordReportAttendanceStatsId = (((ReportAttendanceStatsDecorator) savedReportAttendanceStats.getRecord()).getId();
		
		ReportAttendanceStats reportattendancestats = record.createReportAttendanceStats(vmjExchange);
		ReportAttendanceStats reportattendancestatsdeco = ReportAttendanceStatsFactory.createReportAttendanceStats("TicketingSystem.attendancestats.core.ReportImpl", id, reportattendancestats, idReport, idEvent, eventName, eventDate, reportDate, ticketSold, eventimpl
		showingAttendance, attendancePercentage
		);
			return reportattendancestatsdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/attendancestats/update")
    public HashMap<String, Object> updateReportAttendanceStats(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);
		
		ReportAttendanceStats reportattendancestats = reportattendancestatsRepository.getObject(id);
		reportattendancestats = createReportAttendanceStats(vmjExchange, id);
		
		reportattendancestatsRepository.updateObject(reportattendancestats);
		reportattendancestats = reportattendancestatsRepository.getObject(id);
		//to do: fix association attributes
		
		return reportattendancestats.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/attendancestats/detail")
    public HashMap<String, Object> getReportAttendanceStats(VMJExchange vmjExchange){
		return record.getReportAttendanceStats(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/attendancestats/list")
    public List<HashMap<String,Object>> getAllReportAttendanceStats(VMJExchange vmjExchange){
		List<ReportAttendanceStats> reportattendancestatsList = reportattendancestatsRepository.getAllObject("reportattendancestats_impl");
		return transformReportAttendanceStatsListToHashMap(reportattendancestatsList);
	}

    public List<HashMap<String,Object>> transformReportAttendanceStatsListToHashMap(List<ReportAttendanceStats> ReportAttendanceStatsList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReportAttendanceStatsList.size(); i++) {
            resultList.add(ReportAttendanceStatsList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/attendancestats/delete")
    public List<HashMap<String,Object>> deleteReportAttendanceStats(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);
		reportattendancestatsRepository.deleteObject(id);
		return getAllReportAttendanceStats(vmjExchange);
	}

	public void calculateAttendancePercentage() {
		// TODO: implement this method
	}
	
}
