package TicketingSystem.report.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ReportResourceDecorator extends ReportResourceComponent{
	protected ReportResourceComponent record;

    public ReportResourceDecorator(ReportResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		return record.saveReport(vmjExchange);
	}

    public Report createReport(VMJExchange vmjExchange){
		return record.createReport(vmjExchange);
	}

    public Report createReport(VMJExchange vmjExchange, int id){
		return record.createReport(vmjExchange, id);
	}

    public HashMap<String, Object> updateReport(VMJExchange vmjExchange){
		return record.updateReport(vmjExchange);
	}

    public HashMap<String, Object> getReport(VMJExchange vmjExchange){
		return record.getReport(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange){
		return record.getAllReport(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange){
		return record.deleteReport(vmjExchange);
	}

	public void generateReport() {
		return record.generateReport();
	}
}
