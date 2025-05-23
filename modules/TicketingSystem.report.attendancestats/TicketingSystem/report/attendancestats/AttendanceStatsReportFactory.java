package TicketingSystem.report.attendancestats;

public class AttendanceStatsReportFactory {
    
    public static AttendanceStatsReport createReport() {
        return new AttendanceStatsReportImpl();
    }
    
    public static AttendanceStatsReport createReport(String id, int showingAttendance, int attendancePercentage) {
        return new AttendanceStatsReportImpl(id, showingAttendance, attendancePercentage);
    }
} 