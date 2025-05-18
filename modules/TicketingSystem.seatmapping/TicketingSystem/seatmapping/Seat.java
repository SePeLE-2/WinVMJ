package TicketingSystem.seatmapping;

import java.util.HashMap;

public interface Seat {
    String getSeatNumber();
    void setSeatNumber(String seatNumber);
    String getRow();
    void setRow(String row);
    boolean getIsOccupied();
    void setIsOccupied(boolean isOccupied);
    int getOccupantId();
    void setOccupantId(int occupantId);
    HashMap<String, Object> toHashMap();
} 