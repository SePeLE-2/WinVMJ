package TicketingSystem.report.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.report.ReportFactory;
import vmj.auth.annotations.Restricted;
//add other required packages


public class ReportResourceImpl extends ReportResourceComponent{
	
	private ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

	
    @Route(url="call/report/save")
    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Report report = createReport(vmjExchange);
		reportRepository.saveObject(report);
		return getAllReport(vmjExchange);
	}

	
    @Route(url="call/report")
    public HashMap<String,Object> report(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportServiceImpl.createReport(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Report createReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportServiceImpl.createReport(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Report createReport(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Report result = reportServiceImpl.createReport(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/report/update")
    public HashMap<String, Object> updateReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reportServiceImpl.updateReport(requestBody);
		
	}

	
    @Route(url="call/report/detail")
    public HashMap<String, Object> getReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reportServiceImpl.getReport(requestBody);
	}

	
    @Route(url="call/report/list")
    public List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reportServiceImpl.getAllReport(requestBody);
	}

	
    @Route(url="call/report/delete")
    public List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reportServiceImpl.deleteReport(requestBody);
	}


	
	public void generateReport() {
		// TODO: implement this method
	}
}
