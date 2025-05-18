package TicketingSystem.seatmapping;

import java.util.HashMap;

public class SeatImpl implements Seat {
    private String seatNumber;
    private String row;
    private boolean isOccupied;
    private int occupantId;
    
    public SeatImpl() {
        // Default constructor
    }
    
    @Override
    public String getSeatNumber() {
        return seatNumber;
    }
    
    @Override
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    @Override
    public String getRow() {
        return row;
    }
    
    @Override
    public void setRow(String row) {
        this.row = row;
    }
    
    @Override
    public boolean getIsOccupied() {
        return isOccupied;
    }
    
    @Override
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    
    @Override
    public int getOccupantId() {
        return occupantId;
    }
    
    @Override
    public void setOccupantId(int occupantId) {
        this.occupantId = occupantId;
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("seatNumber", seatNumber);
        map.put("row", row);
        map.put("isOccupied", isOccupied);
        map.put("occupantId", occupantId);
        return map;
    }
} 