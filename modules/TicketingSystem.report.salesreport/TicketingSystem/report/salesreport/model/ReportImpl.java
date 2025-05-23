package TicketingSystem.report.salesreport;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.report.core.ReportDecorator;
import TicketingSystem.report.core.Report;
import TicketingSystem.report.core.ReportComponent;

import TicketingSystem.event.core.EventImpl;

@Entity(name = "report_salesreport")
@Table(name = "report_salesreport")
public class ReportImpl extends ReportDecorator {

	protected int totalRevenue;
	protected int ticketPrice;

	public ReportImpl() {
		super();
		this.objectName = ReportImpl.class.getName();
	}

	public ReportImpl(int totalRevenue, int ticketPrice) {
		super();
		this.totalRevenue = totalRevenue;
		this.ticketPrice = ticketPrice;
		this.objectName = ReportImpl.class.getName();
	}

	public ReportImpl(ReportComponent record, int totalRevenue, int ticketPrice) {
		super(record);
		this.totalRevenue = totalRevenue;
		this.ticketPrice = ticketPrice;
		this.objectName = ReportImpl.class.getName();
	}

	public int getTotalRevenue() {
		return this.totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public int getTicketPrice() {
		return this.ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public EventImpl getEventimpl() {
		return this.eventimpl;
	}

	public void setEventimpl(EventImpl eventimpl) {
		this.eventimpl = eventimpl;
	}

	public void calculateRevenue() {
		this.totalRevenue = this.ticketSold * this.ticketPrice;
	}

}
