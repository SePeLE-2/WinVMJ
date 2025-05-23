package TicketingSystem.report.salesreport;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportResourceDecorator;
import TicketingSystem.report.core.ReportServiceComponent;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportService;
import TicketingSystem.report.salesreport.ReportServiceImpl;
import TicketingSystem.report.core.ReportResourceComponent;
import TicketingSystem.report.core.Report;
import TicketingSystem.report.ReportFactory;
import TicketingSystem.report.core.ReportDecorator;

import TicketingSystem.event.core.EventImpl;

public class ReportResourceImpl extends ReportResourceDecorator {
	private ReportFactory ReportSalesReportFactory = new ReportFactory();
	private ReportService reportService;

	public ReportResourceImpl(ReportResourceComponent record, ReportServiceComponent reportService) {
		super(record);
		this.reportService =  new ReportServiceImpl(reportService);
	}

	@Route(url = "call/salesreport/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		Report reportsalesreport = reportService.createReport(requestBody);
		Repository.saveObject(reportsalesreport);
		return getAllReportSalesReport(vmjExchange);
	}

	public Report createReportSalesReport(VMJExchange vmjExchange) {
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);

		String ticketPriceStr = (String) vmjExchange.getRequestBodyForm("ticketPrice");
		int ticketPrice = Integer.parseInt(ticketPriceStr);

		String idReportStr = (String) vmjExchange.getRequestBodyForm("idReport");
		int idReport = Integer.parseInt(idReportStr);

		String idEventStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int idEvent = Integer.parseInt(idEventStr);

		String eventNameStr = (String) vmjExchange.getRequestBodyForm("eventName");
		String eventName = eventNameStr;

		String eventDateStr = (String) vmjExchange.getRequestBodyForm("eventDate");
		String eventDate = eventDateStr;

		String reportDateStr = (String) vmjExchange.getRequestBodyForm("reportDate");
		String reportDate = reportDateStr;

		String ticketSoldStr = (String) vmjExchange.getRequestBodyForm("ticketSold");
		int ticketSold = Integer.parseInt(ticketSoldStr);

		EventImpl eventimpl = new EventImpl();

		Report reportsalesreport = record.createReport(vmjExchange);
		Report reportsalesreportdeco = ReportSalesReportFactory.createReport(
				"TicketingSystem.salesreport.core.ReportImpl",
				reportsalesreport,
				idReport,
				idEvent,
				eventName,
				eventDate,
				reportDate,
				ticketSold,
				eventimpl,
				totalRevenue,
				ticketPrice);
		return reportsalesreportdeco;
	}

	public Report createReportSalesReport(VMJExchange vmjExchange, int id) {
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);

		String ticketPriceStr = (String) vmjExchange.getRequestBodyForm("ticketPrice");
		int ticketPrice = Integer.parseInt(ticketPriceStr);

		String idReportStr = (String) vmjExchange.getRequestBodyForm("idReport");
		int idReport = Integer.parseInt(idReportStr);

		String idEventStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int idEvent = Integer.parseInt(idEventStr);

		String eventNameStr = (String) vmjExchange.getRequestBodyForm("eventName");
		String eventName = eventNameStr;

		String eventDateStr = (String) vmjExchange.getRequestBodyForm("eventDate");
		String eventDate = eventDateStr;

		String reportDateStr = (String) vmjExchange.getRequestBodyForm("reportDate");
		String reportDate = reportDateStr;

		String ticketSoldStr = (String) vmjExchange.getRequestBodyForm("ticketSold");
		int ticketSold = Integer.parseInt(ticketSoldStr);

		EventImpl eventimpl = new EventImpl();

		Report reportsalesreport = Repository.getObject(id);
		reportsalesreport = record.createReport(vmjExchange);
		Report reportsalesreportdeco = ReportSalesReportFactory.createReport(
				"TicketingSystem.salesreport.core.ReportImpl",
				id,
				reportsalesreport,
				idReport,
				idEvent,
				eventName,
				eventDate,
				reportDate,
				ticketSold,
				eventimpl,
				totalRevenue,
				ticketPrice);
		return reportsalesreportdeco;
	}

	@Route(url = "call/salesreport/update")
	public HashMap<String, Object> updateReportSalesReport(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);

		Report reportsalesreport = Repository.getObject(id);
		reportsalesreport = createReportSalesReport(vmjExchange, id);

		Repository.updateObject(reportsalesreport);
		reportsalesreport = Repository.getObject(id);
		// to do: fix association attributes

		return reportsalesreport.toHashMap();

	}

	@Route(url = "call/salesreport/detail")
	public HashMap<String, Object> getReportSalesReport(VMJExchange vmjExchange) {
		return record.getReport(vmjExchange);
	}

	@Route(url = "call/salesreport/list")
	public List<HashMap<String, Object>> getAllReportSalesReport(VMJExchange vmjExchange) {
		List<Report> reportsalesreportList = Repository
				.getAllObject("reportsalesreport_impl");
		return transformReportSalesReportListToHashMap(reportsalesreportList);
	}

	public List<HashMap<String, Object>> transformReportSalesReportListToHashMap(
			List<Report> ReportSalesReportList) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < ReportSalesReportList.size(); i++) {
			resultList.add(ReportSalesReportList.get(i).toHashMap());
		}

		return resultList;
	}

	@Route(url = "call/salesreport/delete")
	public List<HashMap<String, Object>> deleteReportSalesReport(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("idReportidEvent");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReportSalesReport(vmjExchange);
	}

	public void calculateRevenue() {
		// TODO: implement this method
		System.out.println("salesreport calculateRevenue() called in service; this should ideally be in entity logic.");
	}
}
