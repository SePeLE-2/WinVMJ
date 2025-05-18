package TicketingSystem.seatmapping;

public class SeatFactory {
    
    public static Seat createSeat(String seatNumber, String row, boolean isOccupied, int occupantId) {
        SeatImpl seat = new SeatImpl();
        seat.setSeatNumber(seatNumber);
        seat.setRow(row);
        seat.setIsOccupied(isOccupied);
        seat.setOccupantId(occupantId);
        return seat;
    }
} 