package TicketingSystem.report.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import TicketingSystem.event.core.Event;
import TicketingSystem.event.core.EventImpl;

@Entity(name = "report_impl")
@Table(name = "report_impl")
public class ReportImpl extends ReportComponent {

	public ReportImpl(UUID idReport, UUID idEvent, String eventName, String eventDate, String reportDate,
			int ticketSold, EventImpl eventimpl) {
		this.idReport = idReport;
		this.idEvent = idEvent;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.reportDate = reportDate;
		this.ticketSold = ticketSold;
		this.eventimpl = eventimpl;
	}

	public ReportImpl(String eventName, String eventDate, String reportDate, int ticketSold, EventImpl eventimpl) {
		this.idReport = UUID.randomUUID();
		this.idEvent = UUID.randomUUID();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.reportDate = reportDate;
		this.ticketSold = ticketSold;
		this.eventimpl = eventimpl;
	}

	public ReportImpl() {
	}

	public UUID getIdReport() {
		return this.idReport;
	}

	public void setIdReport(UUID idReport) {
		this.idReport = idReport;
	}

	public UUID getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(UUID idEvent) {
		this.idEvent = idEvent;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public int getTicketSold() {
		return this.ticketSold;
	}

	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	public EventImpl getEventimpl() {
		return this.eventimpl;
	}

	public void setEventimpl(EventImpl eventimpl) {
		this.eventimpl = eventimpl;
	}

	public void generateReport() {
		// TODO: implement this method
		System.out.println("generateReport to be implemented");
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> reportMap = new HashMap<String, Object>();
		reportMap.put("idReport", getIdReport());
		reportMap.put("idEvent", getIdEvent());
		reportMap.put("eventName", getEventName());
		reportMap.put("eventDate", getEventDate());
		reportMap.put("reportDate", getReportDate());
		reportMap.put("ticketSold", getTicketSold());
		reportMap.put("eventimpl", getEventimpl());

		return reportMap;
	}

}
