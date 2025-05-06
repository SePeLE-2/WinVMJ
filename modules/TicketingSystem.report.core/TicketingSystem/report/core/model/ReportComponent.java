package TicketingSystem.report.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="report_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReportComponent implements Report{
	@Id
	protected int idReport; protected int idEvent; 
	protected String eventName;
	protected String eventDate;
	protected String reportDate;
	protected int ticketSold;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  eventimpl;
	protected String objectName = ReportComponent.class.getName();

	public ReportComponent() {

	} 

	public ReportComponent(
        int idReport, int idEvent, String eventName, String eventDate, String reportDate, int ticketSold, EventImpl eventimpl
    ) {
        this.idReport = idReport;
        this.idEvent = idEvent;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.reportDate = reportDate;
        this.ticketSold = ticketSold;
        this.eventimpl = eventimpl;
    }

	public int getIdReport() {
		return this.idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}
	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
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
	public abstract EventImpl getEventimpl();
	public abstract void setEventimpl(EventImpl eventimpl);
	
 
	public abstract void generateReport();

	@Override
    public String toString() {
        return "{" +
            " idReport='" + getIdReport() + "'" +
            " idEvent='" + getIdEvent() + "'" +
            " eventName='" + getEventName() + "'" +
            " eventDate='" + getEventDate() + "'" +
            " reportDate='" + getReportDate() + "'" +
            " ticketSold='" + getTicketSold() + "'" +
            " eventimpl='" + getEventimpl() + "'" +
            "}";
    }
	
}
