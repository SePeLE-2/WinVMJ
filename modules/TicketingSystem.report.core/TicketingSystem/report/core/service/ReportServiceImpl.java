package TicketingSystem.report.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.report.ReportFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReportServiceImpl extends ReportServiceComponent{

    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Report report = createReport(vmjExchange);
		reportRepository.saveObject(report);
		return getAllReport(vmjExchange);
	}

    public Report createReport(Map<String, Object> requestBody){
		String idReportStr = (String) requestBody.get("idReport");
		int idReport = Integer.parseInt(idReportStr);
		String idEventStr = (String) requestBody.get("idEvent");
		int idEvent = Integer.parseInt(idEventStr);
		String eventName = (String) requestBody.get("eventName");
		String eventDate = (String) requestBody.get("eventDate");
		String reportDate = (String) requestBody.get("reportDate");
		String ticketSoldStr = (String) requestBody.get("ticketSold");
		int ticketSold = Integer.parseInt(ticketSoldStr);
		
		//to do: fix association attributes
		Report Report = ReportFactory.createReport(
			"TicketingSystem.report.core.ReportImpl",
		idReport
		, idEvent
		, eventName
		, eventDate
		, reportDate
		, ticketSold
		, eventimpl
		);
		Repository.saveObject(report);
		return report;
	}

    public Report createReport(Map<String, Object> requestBody, int id){
		String eventName = (String) vmjExchange.getRequestBodyForm("eventName");
		String eventDate = (String) vmjExchange.getRequestBodyForm("eventDate");
		String reportDate = (String) vmjExchange.getRequestBodyForm("reportDate");
		String ticketSoldStr = (String) vmjExchange.getRequestBodyForm("ticketSold");
		int ticketSold = Integer.parseInt(ticketSoldStr);
		
		//to do: fix association attributes
		
		Report report = ReportFactory.createReport("TicketingSystem.report.core.ReportImpl", eventName, eventDate, reportDate, ticketSold, eventimpl);
		return report;
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idReportidEvent");
		int id = Integer.parseInt(idStr);
		Report report = Repository.getObject(id);
		
		report.setEventName((String) requestBody.get("eventName"));
		report.setEventDate((String) requestBody.get("eventDate"));
		report.setReportDate((String) requestBody.get("reportDate"));
		String ticketSoldStr = (String) requestBody.get("ticketSold");
		report.setTicketSold(Integer.parseInt(ticketSoldStr));
		
		Repository.updateObject(report);
		
		//to do: fix association attributes
		
		return report.toHashMap();
		
	}

    public HashMap<String, Object> getReport(Map<String, Object> requestBody){
		List<HashMap<String, Object>> reportList = getAllReport("report_impl");
		for (HashMap<String, Object> report : reportList){
			int record_id = ((Double) report.get("record_id")).intValue();
			if (record_id == id){
				return report;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReportById(int id){
		String idStr = vmjExchange.getGETParam("idReportidEvent"); 
		int id = Integer.parseInt(idStr);
		Report report = reportRepository.getObject(id);
		return report.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Report> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Report> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReport(requestBody);
	}

	public void generateReport() {
		// TODO: implement this method
	}
}
