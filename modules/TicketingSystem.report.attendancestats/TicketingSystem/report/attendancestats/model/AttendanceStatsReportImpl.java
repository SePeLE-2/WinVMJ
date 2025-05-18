package TicketingSystem.report.attendancestats;

import java.util.*;

public class AttendanceStatsReportImpl implements AttendanceStatsReport {
    private String id;
    private int showingAttendance;
    private int attendancePercentage;
    
    public AttendanceStatsReportImpl() {
        this.id = UUID.randomUUID().toString();
        this.showingAttendance = 0;
        this.attendancePercentage = 0;
    }
    
    public AttendanceStatsReportImpl(String id, int showingAttendance, int attendancePercentage) {
        this.id = id;
        this.showingAttendance = showingAttendance;
        this.attendancePercentage = attendancePercentage;
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public int getShowingAttendance() {
        return showingAttendance;
    }
    
    @Override
    public void setShowingAttendance(int showingAttendance) {
        this.showingAttendance = showingAttendance;
    }
    
    @Override
    public int getAttendancePercentage() {
        return attendancePercentage;
    }
    
    @Override
    public void setAttendancePercentage(int attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
    
    @Override
    public void calculateAttendancePercentage() {
        // Simple implementation for demonstration
        if (showingAttendance > 0) {
            attendancePercentage = 100; // Assume 100% attendance for simplicity
        } else {
            attendancePercentage = 0;
        }
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("showingAttendance", showingAttendance);
        map.put("attendancePercentage", attendancePercentage);
        return map;
    }
} 