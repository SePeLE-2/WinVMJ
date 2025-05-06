package TicketingSystem.report.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReportServiceComponent implements ReportService{
	protected RepositoryUtil<Report> Repository;

    public ReportServiceComponent(){
        this.Repository = new RepositoryUtil<Report>(TicketingSystem.report.core.ReportComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange);
    public abstract Report createReport(Map<String, Object> requestBodye);
	public abstract Report createReport(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateReport(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReport(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Report> List);
    public abstract List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReportById(int id);

	public abstract void generateReport();
}
