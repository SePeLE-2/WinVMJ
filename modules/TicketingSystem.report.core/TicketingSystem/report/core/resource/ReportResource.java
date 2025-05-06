package TicketingSystem.report.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReportResource {
    List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange);
    HashMap<String, Object> updateReport(VMJExchange vmjExchange);
    HashMap<String, Object> getReport(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange);
	HashMap<String, Object> Report(VMJExchange vmjExhange);
}
