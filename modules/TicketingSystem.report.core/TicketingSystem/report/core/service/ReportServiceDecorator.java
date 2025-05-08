package TicketingSystem.report.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ReportServiceDecorator extends ReportServiceComponent{
	protected ReportServiceComponent record;

    public ReportServiceDecorator(ReportServiceComponent record) {
        this.record = record;
    }

	public ReportImpl createReport(Map<String, Object> requestBody){
		return record.createReport(requestBody);
	}

    public Report createReport(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createReport(requestBody, response);
	}

	public HashMap<String, Object> getReport(Map<String, Object> requestBody){
		return record.getReport(requestBody);
	}

	public List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody){
		return record.getAllReport(requestBody);
	}

    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		return record.saveReport(vmjExchange);
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		return record.updateReport(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Report> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody){
		return record.deleteReport(requestBody);
	}

	public HashMap<String, Object> getReportById(int id){
        return record.getReportById(id);
    }

	public void generateReport() {
		return record.generateReport();
	}
}
