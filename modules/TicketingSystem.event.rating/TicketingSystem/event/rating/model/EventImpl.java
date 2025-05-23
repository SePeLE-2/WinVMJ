package TicketingSystem.event.rating;

import TicketingSystem.event.core.EventComponent;
import TicketingSystem.event.core.EventDecorator;

import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.UUID;

@Entity(name = "event_rating")
@Table(name = "event_rating")
public class EventImpl extends EventDecorator {
    public EventImpl() {
        super();
        this.objectName = EventImpl.class.getName();
    }

    public EventImpl(EventComponent record) {
        super(record);
        this.objectName = EventImpl.class.getName();
    }

    public UUID getIdEvent() {
        return this.idEvent;
    }

    public void setIdEvent(UUID idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketImpl getTicketimpl() {
        return this.ticketimpl;
    }

    public void setTicketimpl(TicketImpl ticketimpl) {
        this.ticketimpl = ticketimpl;
    }

    public BundlingImpl getBundlingimpl() {
        return this.bundlingimpl;
    }

    public void setBundlingimpl(BundlingImpl bundlingimpl) {
        this.bundlingimpl = bundlingimpl;
    }

    public void createEvent() {

    }

    public void addRating() {
        // TODO: implement this method
    }

    public int getAverageRating() {
        // TODO: implement this method
        return 0;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = super.toHashMap();
        map.put("averageRating", getAverageRating());
        return map;
    }

    // public void addRating(int value) {
    // this.rating.addRating(value);
    // }

    // public int getAverageRating() {
    // return this.rating.getAverageRating();
    // }

    // public void addRating(int rating) {
    // totalRating += rating;
    // ratingCount++;
    // }

    // public int getAverageRating() {
    // return ratingCount == 0 ? 0 : totalRating / ratingCount;
    // }
}
