package TicketingSystem.report.core;
import java.util.*;

public interface ReportService {
	Report createReport(Map<String, Object> requestBody);
	Report createReport(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getReport(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReport(Map<String, Object> requestBody);
    HashMap<String, Object> updateReport(Map<String, Object> requestBody);
    HashMap<String, Object> getReportById(UUID id);
    List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Report> List);
}
