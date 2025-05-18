package TicketingSystem.event.rating;

import TicketingSystem.event.core.Event;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class EventRatingFactory {
    private static final Logger LOGGER = Logger.getLogger(EventRatingFactory.class.getName());

    public static Event createEventRating(String fqn, Object... args) {
        try {
            Class<?> clz = Class.forName(fqn);
            Constructor<?> ctor = clz.getDeclaredConstructors()[0];
            return (Event) ctor.newInstance(args);
        } catch (Exception e) {
            LOGGER.severe("Failed to create event rating: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
