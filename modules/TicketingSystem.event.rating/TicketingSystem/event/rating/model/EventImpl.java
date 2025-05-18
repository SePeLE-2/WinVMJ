package TicketingSystem.event.rating.model;

import TicketingSystem.event.core.EventComponent;
import TicketingSystem.event.core.EventDecorator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.UUID;

@Entity(name = "event_rating")
@Table(name = "event_rating")
public class EventImpl extends EventDecorator {
    private Rating rating;

    public EventImpl() {
        super();
        this.objectName = EventImpl.class.getName();
        this.rating = new Rating();
    }

    public EventImpl(EventComponent record) {
        super(record);
        this.objectName = EventImpl.class.getName();
        this.rating = new Rating();
    }

    public void addRating(int value) {
        this.rating.addRating(value);
    }

    public int getAverageRating() {
        return this.rating.getAverageRating();
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = super.toHashMap();
        map.put("averageRating", getAverageRating());
        return map;
    }
}
