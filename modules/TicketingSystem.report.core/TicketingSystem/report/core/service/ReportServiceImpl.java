package TicketingSystem.report.core;

import java.util.*;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.annotations.Restricted;

import TicketingSystem.report.ReportFactory;
import TicketingSystem.event.core.EventImpl;
import TicketingSystem.event.core.EventServiceImpl;

public class ReportServiceImpl extends ReportServiceComponent {

    private final EventServiceImpl eventService = new EventServiceImpl();

    public ReportServiceImpl() {

    }

    @Route(url = "call/report/save")
    public List<HashMap<String, Object>> saveReport(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return saveReport(requestBody);
    }

    @Override
    public List<HashMap<String, Object>> saveReport(Map<String, Object> requestBody) {
        Report report = createReport(requestBody);
        Repository.saveObject(report);
        return getAllReport(requestBody);
    }

    @Override
    public Report createReport(Map<String, Object> requestBody) {
        UUID idReport = UUID.fromString((String) requestBody.get("idReport"));
        UUID idEvent = UUID.fromString((String) requestBody.get("idEvent"));

        EventImpl eventimpl = new EventImpl();

        // EventImpl eventimpl = (EventImpl) eventService.getEventById(intId);

        String eventName = (String) requestBody.get("eventName");
        String eventDate = (String) requestBody.get("eventDate");
        String reportDate = (String) requestBody.get("reportDate");
        int ticketSold = Integer.parseInt((String) requestBody.get("ticketSold"));

        Report report = ReportFactory.createReport(
                "TicketingSystem.report.core.ReportImpl",
                idReport,
                idEvent,
                eventName,
                eventDate,
                reportDate,
                ticketSold,
                eventimpl);

        return report;
    }

    @Override
    public Report createReport(Map<String, Object> requestBody, Map<String, Object> response) {
        return createReport(requestBody);
    }

    @Override
    public HashMap<String, Object> updateReport(Map<String, Object> requestBody) {
        UUID id = UUID.fromString((String) requestBody.get("idReport"));
        Report report = Repository.getObject(id);

        if (report instanceof ReportImpl) {
            ReportImpl rep = (ReportImpl) report;
            rep.setEventName((String) requestBody.get("eventName"));
            rep.setEventDate((String) requestBody.get("eventDate"));
            rep.setReportDate((String) requestBody.get("reportDate"));
            rep.setTicketSold(Integer.parseInt((String) requestBody.get("ticketSold")));
        }

        Repository.updateObject(report);
        return report.toHashMap();
    }

    public HashMap<String, Object> getReportById(UUID id) {
        Report report = Repository.getObject(id);
        return report.toHashMap();
    }

    @Override
    public HashMap<String, Object> getReportById(int id) {
        throw new UnsupportedOperationException("Use UUID instead of int for report ID.");
    }

    @Override
    public HashMap<String, Object> getReport(Map<String, Object> requestBody) {
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Map<String, Object> temp = new HashMap<>();
        temp.put("table_name", "report_impl");

        List<HashMap<String, Object>> reportList = getAllReport(temp);
        for (HashMap<String, Object> report : reportList) {
            UUID recordId = UUID.fromString((String) report.get("record_id"));
            if (recordId.equals(id)) {
                return report;
            }
        }
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getAllReport(Map<String, Object> requestBody) {
        String table = (String) requestBody.get("table_name");
        List<Report> list = Repository.getAllObject(table);
        return transformListToHashMap(list);
    }

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<Report> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (Report report : list) {
            resultList.add(report.toHashMap());
        }
        return resultList;
    }

    @Override
    public List<HashMap<String, Object>> deleteReport(Map<String, Object> requestBody) {
        UUID id = UUID.fromString((String) requestBody.get("id"));
        Repository.deleteObject(id);
        return getAllReport(requestBody);
    }

    @Override
    public void generateReport() {
        // TODO: implement report logic
    }
}
