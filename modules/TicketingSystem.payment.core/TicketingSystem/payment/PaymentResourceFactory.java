package TicketingSystem.payment;

import TicketingSystem.payment.core.PaymentResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PaymentResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(PaymentFactory.class.getName());

    public PaymentResourceFactory()
    {

    }

    public static PaymentResource createPaymentResource(String fullyQualifiedName, Object ... base)
    {
            PaymentResource record = null;
            try {
            // Cari constructor yang cocok
            Class<?> clz = Class.forName(fullyQualifiedName);
            
            Constructor<?>[] constructors = clz.getDeclaredConstructors();
            Constructor<?> constructor = constructors[0]; // default: ambil yang pertama

            // Cetak semua constructor untuk debugging
            LOGGER.info("---- Available constructors for " + fullyQualifiedName + ":");
            for (Constructor<?> c : constructors) {
                LOGGER.info("  " + c.toString());
            }

            // Bisa ditambahkan log parameter types untuk constructor terpilih
            LOGGER.info("Using constructor: " + constructor);

            // Cetak tipe parameter dari constructor yang dipilih
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

            // Gunakan constructor yang dipilih
            record = (PaymentResource) constructor.newInstance(base);


            // Class<?> clz = Class.forName(fullyQualifiedName);
            // Constructor<?>[] constructorList = clz.getDeclaredConstructors();
            
            // Constructor<?> constructor = null;
            // for (int i = 0; i < constructorList.length; i++) {
            //     try {
            //         constructor = constructorList[i];
            //         System.out.println(constructor.toString());
            //         record = (PaymentResource) constructor.newInstance(base);
            //         i = constructorList.length;
            //     } catch (IllegalArgumentException e) {
            //         if (i < constructorList.length - 1) {
            //             System.out.println("Trying other constructor");
            //             continue;
            //     } else {
            //         throw e;
            //     }
            //     }
            // }
        } 
        catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PaymentResourrce.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
        System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of PaymentResourrce.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
        System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of PaymentResourrce.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
        System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Failed to create instance of PaymentResourrce.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
