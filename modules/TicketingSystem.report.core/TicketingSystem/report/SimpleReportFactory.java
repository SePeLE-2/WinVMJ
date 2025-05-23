package TicketingSystem.report;

import TicketingSystem.report.core.SimpleReport;
import TicketingSystem.report.core.SimpleReportImpl;
import java.util.Map;

public class SimpleReportFactory {
    public static SimpleReport createReport(String id, String title, Map<String, Object> data) {
        return new SimpleReportImpl(id, title, data);
    }
    
    public static SimpleReport createReport() {
        return new SimpleReportImpl();
    }
} 