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

@Entity(name="report_salesreport")
@Table(name="report_salesreport")
public class ReportImpl extends ReportDecorator {

	protected int totalRevenue;
	public ReportImpl() {
        super();
        this.objectName = ReportImpl.class.getName();
    }

	    public ReportImpl(int totalRevenue) {
	        super();
	        this.totalRevenue = totalRevenue;
	        this.objectName = ReportImpl.class.getName();
	    }
	
	public ReportImpl(ReportComponent record, int totalRevenue) {
		super(record);
		this.totalRevenue = totalRevenue;
		this.objectName = ReportImpl.class.getName();
	}

	public int getTotalRevenue() {
		return this.totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public void calculateRevenue() {
		// TODO: implement this method
	}

}
