package TicketingSystem.report.salesreport;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.report.core.ReportResourceDecorator;
import TicketingSystem.report.core.ReportImpl;
import TicketingSystem.report.core.ReportServiceImpl;
import TicketingSystem.report.core.ReportResourceComponent;
import TicketingSystem.report.core.Report;
import TicketingSystem.report.ReportFactory;
import TicketingSystem.report.core.ReportDecorator;

import TicketingSystem.event.core.EventImpl;

public class ReportResourceImpl extends ReportResourceDecorator {
	private ReportFactory ReportSalesReportFactory = new ReportFactory();
	private ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

	public ReportResourceImpl(ReportResourceComponent record) {
		super(record);
	}

	@Route(url = "call/salesreport/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		Report reportsalesreport = reportServiceImpl.createReport(requestBody);
		Repository.saveObject(reportsalesreport);
		return getAllReportSalesReport(vmjExchange);
	}

	public Report createReportSalesReport(VMJExchange vmjExchange) {
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);

		String idReportStr = (String) vmjExchange.getRequestBodyForm("idReport");
		int idReport = Integer.parseInt(totalRevenueStr);

		String idEventStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int idEvent = Integer.parseInt(totalRevenueStr);

		String eventNameStr = (String) vmjExchange.getRequestBodyForm("eventName");
		int eventName = Integer.parseInt(totalRevenueStr);

		String eventDateStr = (String) vmjExchange.getRequestBodyForm("eventDate");
		int eventDate = Integer.parseInt(totalRevenueStr);

		String reportDateStr = (String) vmjExchange.getRequestBodyForm("reportDate");
		int reportDate = Integer.parseInt(totalRevenueStr);

		String ticketSoldStr = (String) vmjExchange.getRequestBodyForm("ticketSold");
		int ticketSold = Integer.parseInt(totalRevenueStr);

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
				totalRevenue);
		return reportsalesreportdeco;
	}

	public Report createReportSalesReport(VMJExchange vmjExchange, int id) {
		String totalRevenueStr = (String) vmjExchange.getRequestBodyForm("totalRevenue");
		int totalRevenue = Integer.parseInt(totalRevenueStr);

		String idReportStr = (String) vmjExchange.getRequestBodyForm("idReport");
		int idReport = Integer.parseInt(totalRevenueStr);

		String idEventStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int idEvent = Integer.parseInt(totalRevenueStr);

		String eventNameStr = (String) vmjExchange.getRequestBodyForm("eventName");
		int eventName = Integer.parseInt(totalRevenueStr);

		String eventDateStr = (String) vmjExchange.getRequestBodyForm("eventDate");
		int eventDate = Integer.parseInt(totalRevenueStr);

		String reportDateStr = (String) vmjExchange.getRequestBodyForm("reportDate");
		int reportDate = Integer.parseInt(totalRevenueStr);

		String ticketSoldStr = (String) vmjExchange.getRequestBodyForm("ticketSold");
		int ticketSold = Integer.parseInt(totalRevenueStr);

		EventImpl eventimpl = new EventImpl();

		Report reportsalesreport = Repository.getObject(id);
		// int recordReportSalesReportId = (((ReportDecorator)
		// savedReportSalesReport.getRecord()).getId());

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
				totalRevenue);
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
