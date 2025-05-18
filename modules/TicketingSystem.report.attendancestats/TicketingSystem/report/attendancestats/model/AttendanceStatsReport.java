package TicketingSystem.report.attendancestats;

import java.util.*;

public interface AttendanceStatsReport {
    String getId();
    void setId(String id);
    int getShowingAttendance();
    void setShowingAttendance(int showingAttendance);
    int getAttendancePercentage();
    void setAttendancePercentage(int attendancePercentage);
    void calculateAttendancePercentage();
    HashMap<String, Object> toHashMap();
} 