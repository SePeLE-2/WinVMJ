package TicketingSystem.event.rating.model;

public class Rating {
    private int totalRating;
    private int ratingCount;

    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }

    public int getAverageRating() {
        return ratingCount == 0 ? 0 : totalRating / ratingCount;
    }
}
