package TicketingSystem.report.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReportDecorator extends ReportComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReportComponent record;

	public ReportDecorator () {
		super();
		this.record = record;
		this.idReportidEvent =  idReportidEvent.randomUUID();
	}
		
	public ReportDecorator (ReportComponent record) {
		this.idReportidEvent =  idReportidEvent.randomUUID();
		this.record = record;
	}

	public ReportDecorator (int idReportint idEvent, ReportComponent record) {
		this.idReportidEvent =  idReportidEvent;
		this.record = record;
	}
	
	public ReportDecorator (ReportComponent record, String objectName) {
		this.idReportidEvent =  idReportidEvent.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public int getIdReport() {
		return record.getIdReport();
	}
	public void setIdReport(int idReport) {
		record.setIdReport(idReport);
	}
	public int getIdEvent() {
		return record.getIdEvent();
	}
	public void setIdEvent(int idEvent) {
		record.setIdEvent(idEvent);
	}
	public String getEventName() {
		return record.getEventName();
	}
	public void setEventName(String eventName) {
		record.setEventName(eventName);
	}
	public String getEventDate() {
		return record.getEventDate();
	}
	public void setEventDate(String eventDate) {
		record.setEventDate(eventDate);
	}
	public String getReportDate() {
		return record.getReportDate();
	}
	public void setReportDate(String reportDate) {
		record.setReportDate(reportDate);
	}
	public int getTicketSold() {
		return record.getTicketSold();
	}
	public void setTicketSold(int ticketSold) {
		record.setTicketSold(ticketSold);
	}

	public void generateReport() {
		return record.generateReport();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
