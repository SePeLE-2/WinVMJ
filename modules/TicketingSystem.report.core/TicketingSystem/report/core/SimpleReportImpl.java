package TicketingSystem.report.core;
import java.util.*;

public class SimpleReportImpl implements SimpleReport {
    private String id;
    private String title;
    private Map<String, Object> data;
    
    public SimpleReportImpl() {
        this.id = UUID.randomUUID().toString();
        this.title = "";
        this.data = new HashMap<>();
    }
    
    public SimpleReportImpl(String id, String title, Map<String, Object> data) {
        this.id = id;
        this.title = title;
        this.data = data;
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
    public String getTitle() {
        return title;
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public Map<String, Object> getData() {
        return data;
    }
    
    @Override
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("data", data);
        return map;
    }
} 