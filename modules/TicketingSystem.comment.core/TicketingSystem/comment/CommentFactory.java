package TicketingSystem.comment;

import TicketingSystem.comment.core.Comment;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CommentFactory{
    private static final Logger LOGGER = Logger.getLogger(CommentFactory.class.getName());

    public CommentFactory()
    {

    }

    public static Comment createComment(String fullyQualifiedName, Object ... base)
    {
        Comment record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?>[] constructorList = clz.getDeclaredConstructors();

            // Cetak semua constructor untuk debugging
            LOGGER.info("---- Available constructors for " + fullyQualifiedName + ":");
            for (Constructor<?> c : constructorList) {
                LOGGER.info("  " + c.toString());
            }

            Constructor<?> constructor = null;

            for (int i = 0; i < constructorList.length; i++) {
                try {
                    constructor = constructorList[i];

                    LOGGER.info("Trying constructor: " + constructor.toString());

                    // Cetak tipe parameter dari constructor yang sedang dicoba
                    Class<?>[] paramTypes = constructor.getParameterTypes();
                    LOGGER.info("Constructor parameter types:");
                    for (Class<?> type : paramTypes) {
                        LOGGER.info(" - " + type.getName());
                    }

                    // Cetak argumen yang diberikan saat runtime
                    LOGGER.info("Provided arguments for constructor:");
                    for (Object obj : base) {
                        LOGGER.info(" - Value: " + obj + ", Type: " + (obj == null ? "null" : obj.getClass().getName()));
                    }

                    // Mencoba membuat instance
                    record = (Comment) constructor.newInstance(base);

                    // Berhasil, keluar dari loop
                    i = constructorList.length;
                } catch (IllegalArgumentException e) {
                    if (i < constructorList.length - 1) {
                        LOGGER.info("Constructor mismatch, trying next one...");
                        continue;
                    } else {
                        throw e;
                    }
                }
            }
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Comment.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Comment.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of Comment.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of Comment.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
