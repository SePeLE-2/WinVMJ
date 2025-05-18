package TicketingSystem.report.core;
import java.util.*;

public interface SimpleReport {
    String getId();
    void setId(String id);
    String getTitle();
    void setTitle(String title);
    Map<String, Object> getData();
    void setData(Map<String, Object> data);
    HashMap<String, Object> toHashMap();
} 