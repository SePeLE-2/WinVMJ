package TicketingSystem.report.salesreport;
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

    
    @Route(url="call/salesreport/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ReportSalesReport reportsalesreport = createReportSalesReport(vmjExchange);
		reportsalesreportRepository.saveObject(reportsalesreport);
		return getAllReportSalesReport(vmjExchange);
	}

    public Report createReportSalesReport(VMJExchange vmjExchange){
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);
		
		ReportSalesReport reportsalesreport = record.createReportSalesReport(vmjExchange);
		ReportSalesReport reportsalesreportdeco = ReportSalesReportFactory.createReportSalesReport("TicketingSystem.salesreport.core.ReportImpl", reportsalesreport, idReport, idEvent, eventName, eventDate, reportDate, ticketSold, eventimpl
		totalRevenue
		);
			return reportsalesreportdeco;
	}


    public Report createReportSalesReport(VMJExchange vmjExchange, int id){
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);
		ReportSalesReport reportsalesreport = reportsalesreportRepository.getObject(id);
		int recordReportSalesReportId = (((ReportSalesReportDecorator) savedReportSalesReport.getRecord()).getId();
		
		ReportSalesReport reportsalesreport = record.createReportSalesReport(vmjExchange);
		ReportSalesReport reportsalesreportdeco = ReportSalesReportFactory.createReportSalesReport("TicketingSystem.salesreport.core.ReportImpl", id, reportsalesreport, idReport, idEvent, eventName, eventDate, reportDate, ticketSold, eventimpl
		totalRevenue
		);
			return reportsalesreportdeco;
	}

	
    @Route(url="call/salesreport/update")
    public HashMap<String, Object> updateReportSalesReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);
		
		ReportSalesReport reportsalesreport = reportsalesreportRepository.getObject(id);
		reportsalesreport = createReportSalesReport(vmjExchange, id);
		
		reportsalesreportRepository.updateObject(reportsalesreport);
		reportsalesreport = reportsalesreportRepository.getObject(id);
		//to do: fix association attributes
		
		return reportsalesreport.toHashMap();
		
	}

	
    @Route(url="call/salesreport/detail")
    public HashMap<String, Object> getReportSalesReport(VMJExchange vmjExchange){
		return record.getReportSalesReport(vmjExchange);
	}

	
    @Route(url="call/salesreport/list")
    public List<HashMap<String,Object>> getAllReportSalesReport(VMJExchange vmjExchange){
		List<ReportSalesReport> reportsalesreportList = reportsalesreportRepository.getAllObject("reportsalesreport_impl");
		return transformReportSalesReportListToHashMap(reportsalesreportList);
	}

    public List<HashMap<String,Object>> transformReportSalesReportListToHashMap(List<ReportSalesReport> ReportSalesReportList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReportSalesReportList.size(); i++) {
            resultList.add(ReportSalesReportList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/salesreport/delete")
    public List<HashMap<String,Object>> deleteReportSalesReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);
		reportsalesreportRepository.deleteObject(id);
		return getAllReportSalesReport(vmjExchange);
	}

	public void calculateRevenue() {
		// TODO: implement this method
	}
	
}
