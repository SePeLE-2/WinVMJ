package ticketingsystem.product.default;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vmj.routing.route.VMJCors;
import vmj.routing.route.VMJServer;
import vmj.routing.route.Router;
import vmj.hibernate.integrator.HibernateUtil;
import org.hibernate.cfg.Configuration;

import vmj.auth.model.UserResourceFactory;
import vmj.auth.model.RoleResourceFactory;
import vmj.auth.model.core.UserResource;
import vmj.auth.model.core.RoleResource;

import TicketingSystem.event.EventResourceFactory;
import TicketingSystem.event.core.EventResource;
import TicketingSystem.event.EventServiceFactory;
import TicketingSystem.event.core.EventService;
import TicketingSystem.eventorganizer.EventOrganizerResourceFactory;
import TicketingSystem.eventorganizer.core.EventOrganizerResource;
import TicketingSystem.eventorganizer.EventOrganizerServiceFactory;
import TicketingSystem.eventorganizer.core.EventOrganizerService;
import TicketingSystem.payment.PaymentResourceFactory;
import TicketingSystem.payment.core.PaymentResource;
import TicketingSystem.payment.PaymentServiceFactory;
import TicketingSystem.payment.core.PaymentService;
import TicketingSystem.ticket.TicketResourceFactory;
import TicketingSystem.ticket.core.TicketResource;
import TicketingSystem.ticket.TicketServiceFactory;
import TicketingSystem.ticket.core.TicketService;

public class Default {

	public static void main(String[] args) {

		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(vmj.auth.model.core.Role.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRole.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.User.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.passworded.UserImpl.class);

		configuration.addAnnotatedClass(TicketingSystem.event.core.Event.class);
		configuration.addAnnotatedClass(TicketingSystem.event.core.EventComponent.class);
		configuration.addAnnotatedClass(TicketingSystem.event.core.EventDecorator.class);
		configuration.addAnnotatedClass(TicketingSystem.event.core.EventImpl.class);
		configuration.addAnnotatedClass(TicketingSystem.eventorganizer.core.EventOrganizer.class);
		configuration.addAnnotatedClass(TicketingSystem.eventorganizer.core.EventOrganizerComponent.class);
		configuration.addAnnotatedClass(TicketingSystem.eventorganizer.core.EventOrganizerDecorator.class);
		configuration.addAnnotatedClass(TicketingSystem.eventorganizer.core.EventOrganizerImpl.class);
		configuration.addAnnotatedClass(TicketingSystem.payment.core.Payment.class);
		configuration.addAnnotatedClass(TicketingSystem.payment.core.PaymentComponent.class);
		configuration.addAnnotatedClass(TicketingSystem.payment.core.PaymentDecorator.class);
		configuration.addAnnotatedClass(TicketingSystem.payment.core.PaymentImpl.class);
		configuration.addAnnotatedClass(TicketingSystem.payment.creditcard.PaymentImpl.class);
		configuration.addAnnotatedClass(TicketingSystem.ticket.core.Ticket.class);
		configuration.addAnnotatedClass(TicketingSystem.ticket.core.TicketComponent.class);
		configuration.addAnnotatedClass(TicketingSystem.ticket.core.TicketDecorator.class);
		configuration.addAnnotatedClass(TicketingSystem.ticket.core.TicketImpl.class);
		configuration.addAnnotatedClass(TicketingSystem.report.salesreport.ReportImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		HibernateUtil.buildSessionFactory(configuration);

		createObjectsAndBindEndPoints();
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("vmj.auth.model.core.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("vmj.auth.model.core.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("vmj.auth.model.passworded.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("vmj.auth.model.core.UserResourceImpl"));

        EventService eventEvent2Service = EventServiceFactory
            .createEventService("TicketingSystem.event.core.EventServiceImpl"
            	);		

        EventResource eventEvent2Resource = EventResourceFactory
            .createEventResource("TicketingSystem.event.core.EventResourceImpl"
                );
			
        EventOrganizerService eventorganizerEventOrganizer2Service = EventOrganizerServiceFactory
            .createEventOrganizerService("TicketingSystem.eventorganizer.core.EventOrganizerServiceImpl"
            	);		

        EventOrganizerResource eventorganizerEventOrganizer2Resource = EventOrganizerResourceFactory
            .createEventOrganizerResource("TicketingSystem.eventorganizer.core.EventOrganizerResourceImpl"
                );
			
        PaymentService paymentPayment2Service = PaymentServiceFactory
            .createPaymentService("TicketingSystem.payment.core.PaymentServiceImpl"
            	);		

        PaymentResource paymentPayment2Resource = PaymentResourceFactory
            .createPaymentResource("TicketingSystem.payment.core.PaymentResourceImpl"
                );
			
        PaymentService creditcardPayment2Service = PaymentServiceFactory
            .createPaymentService("TicketingSystem.payment.creditcard.PaymentServiceImpl"
            	, paymentPayment2Service);		

        PaymentResource creditcardPayment2Resource = PaymentResourceFactory
            .createPaymentResource("TicketingSystem.payment.creditcard.PaymentResourceImpl"
                , paymentPayment2Resource, paymentPayment2Service);
			
        TicketService ticketTicket2Service = TicketServiceFactory
            .createTicketService("TicketingSystem.ticket.core.TicketServiceImpl"
            	);		

        TicketResource ticketTicket2Resource = TicketResourceFactory
            .createTicketResource("TicketingSystem.ticket.core.TicketResourceImpl"
                );
			
        ReportService salesreportReport2Service = ReportServiceFactory
            .createReportService("TicketingSystem.report.salesreport.ReportServiceImpl"
            	);		

        ReportResource salesreportReport2Resource = ReportResourceFactory
            .createReportResource("TicketingSystem.report.salesreport.ReportResourceImpl"
                );
			

		System.out.println("salesreportReport2Resource endpoints binding");
		Router.route(salesreportReport2Resource);
		
		System.out.println("salesreportReport2Service endpoints binding");
		Router.route(salesreportReport2Service);
		
		System.out.println("ticketTicket2Resource endpoints binding");
		Router.route(ticketTicket2Resource);
		
		System.out.println("ticketTicket2Service endpoints binding");
		Router.route(ticketTicket2Service);
		
		System.out.println("creditcardPayment2Resource endpoints binding");
		Router.route(creditcardPayment2Resource);
		
		System.out.println("creditcardPayment2Service endpoints binding");
		Router.route(creditcardPayment2Service);
		
		System.out.println("paymentPayment2Resource endpoints binding");
		Router.route(paymentPayment2Resource);
		
		System.out.println("paymentPayment2Service endpoints binding");
		Router.route(paymentPayment2Service);
		
		System.out.println("eventorganizerEventOrganizer2Resource endpoints binding");
		Router.route(eventorganizerEventOrganizer2Resource);
		
		System.out.println("eventorganizerEventOrganizer2Service endpoints binding");
		Router.route(eventorganizerEventOrganizer2Service);
		
		System.out.println("eventEvent2Resource endpoints binding");
		Router.route(eventEvent2Resource);
		
		System.out.println("eventEvent2Service endpoints binding");
		Router.route(eventEvent2Service);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            TicketingSystem.event.core.EventComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					TicketingSystem.event.core.EventComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            TicketingSystem.eventorganizer.core.EventOrganizerComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					TicketingSystem.eventorganizer.core.EventOrganizerComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            TicketingSystem.payment.core.PaymentComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					TicketingSystem.payment.core.PaymentComponent.class.getName()
				});
				put("deltas", new String[] {
					TicketingSystem.payment.creditcard.PaymentImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            TicketingSystem.ticket.core.TicketComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					TicketingSystem.ticket.core.TicketComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }

	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        } catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			System.out.println("Buat file cors.properties terlebih dahulu pada src-gen/(namaProduk) dengan contoh sebagai berikut:");
			System.out.println("allowedMethod = GET, POST");
			System.out.println("allowedOrigin = http://example.com");
        }
    }


}