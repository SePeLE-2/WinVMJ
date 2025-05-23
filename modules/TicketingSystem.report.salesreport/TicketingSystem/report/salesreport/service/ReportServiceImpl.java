package TicketingSystem.report.salesreport;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportServiceDecorator;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportServiceComponent;
import TicketingSystem.report.core.Report;
import TicketingSystem.report.core.Repository;

public class ReportServiceImpl extends ReportServiceDecorator {
    public ReportServiceImpl(ReportServiceComponent record) {
        super(record);
    }

    public void calculateRevenue() {
        List<Report> reports = Repository.getAllObject("report_salesreport");
        for (Report report : reports) {
            if (report instanceof ReportImpl) {
                ReportImpl salesReport = (ReportImpl) report;
                salesReport.calculateRevenue();
                Repository.updateObject(salesReport);
            }
        }
    }

    public List<HashMap<String, Object>> saveReport(Map<String, Object> requestBody) {
        return record.saveReport(requestBody);
    }

    @Override
    public HashMap<String, Object> getReportById(int id) {
        throw new UnsupportedOperationException("Use UUID instead of int for report ID.");
    }

    public Report createReport(Map<String, Object> requestBody) {
        return record.createReport(requestBody);
    }

    public Report createReport(Map<String, Object> requestBody, Map<String, Object> response) {
        return record.createReport(requestBody, response);
    }

    public HashMap<String, Object> getReport(Map<String, Object> requestBody) {
        return record.getReport(requestBody);
    }

    public List<HashMap<String, Object>> getAllReport(Map<String, Object> requestBody) {
        return record.getAllReport(requestBody);
    }

    public List<HashMap<String, Object>> saveReport(VMJExchange vmjExchange) {
        return record.saveReport(vmjExchange);
    }

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody) {
        return record.updateReport(requestBody);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Report> List) {
        return record.transformListToHashMap(List);
    }

    public List<HashMap<String, Object>> deleteReport(Map<String, Object> requestBody) {
        return record.deleteReport(requestBody);
    }

    public HashMap<String, Object> getReportById(UUID id) {
        return record.getReportById(id);
    }
}
