package TicketingSystem.report.attendancestats;

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

@Entity(name="report_attendancestats")
@Table(name="report_attendancestats")
public class ReportImpl extends ReportDecorator {

	protected int showingAttendance;
	public int attendancePercentage;
	public EventImpl eventimpl;

	public ReportImpl() {
		super();
		this.objectName = ReportImpl.class.getName();
	}

	public ReportImpl(int showingAttendance, int attendancePercentage) {
		super();
		this.showingAttendance = showingAttendance;
		this.attendancePercentage = attendancePercentage;
		this.objectName = ReportImpl.class.getName();
	}

	public ReportImpl(ReportComponent record, int showingAttendance, int attendancePercentage) {
		super(record);
		this.showingAttendance = showingAttendance;
		this.attendancePercentage = attendancePercentage;
		this.objectName = ReportImpl.class.getName();
	}

	public int getShowingAttendance() {
		return this.showingAttendance;
	}

	public void setShowingAttendance(int showingAttendance) {
		this.showingAttendance = showingAttendance;
	}

	public void calculateAttendancePercentage() {
		if (this.ticketSold > 0) {
			this.attendancePercentage = (int) Math.round((double) this.showingAttendance / this.ticketSold * 100);
		} else {
			this.attendancePercentage = 0;
		}
	}

	@Override
	public EventImpl getEventimpl() {
		return this.eventimpl;
	}

	@Override
	public void setEventimpl(EventImpl eventimpl) {
		this.eventimpl = eventimpl;
	}

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = super.toHashMap();
		map.put("showingAttendance", showingAttendance);
		map.put("attendancePercentage", attendancePercentage);
		return map;
	}
}
