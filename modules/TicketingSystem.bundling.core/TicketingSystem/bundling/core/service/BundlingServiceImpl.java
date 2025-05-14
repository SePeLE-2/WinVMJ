package TicketingSystem.bundling.core;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.bundling.BundlingFactory;
import TicketingSystem.ticket.core.TicketImpl;

public class BundlingServiceImpl extends BundlingServiceComponent {

    @Override
    public Bundling saveBundling(HashMap<String, Object> body, String email) {
        if (!body.containsKey("bundlingName")) {
            throw new FieldValidationException("Field 'bundlingName' not found in the request body.");
        }
        String bundlingName = (String) body.get("bundlingName");

        if (!body.containsKey("price")) {
            throw new FieldValidationException("Field 'price' not found in the request body.");
        }
        String priceStr = (String) body.get("price");
        int price = Integer.parseInt(priceStr);

        if (!body.containsKey("availability")) {
            throw new FieldValidationException("Field 'availability' not found in the request body.");
        }
        String availabilityStr = (String) body.get("availability");
        int availability = Integer.parseInt(availabilityStr);

        UUID bundlingId = UUID.randomUUID();

        Bundling bundling = BundlingFactory.createBundling("TicketingSystem.bundling.core.BundlingImpl",
                bundlingId,
                bundlingName,
                price,
                availability);
        bundlingRepository.saveObject(bundling);
        return bundlingRepository.getObject(bundlingId);
    }

    // @Override
    // public Bundling createBundling(Map<String, Object> requestBody) {
    // String bundlingName = (String) requestBody.get("bundlingName");
    // int price = Integer.parseInt((String) requestBody.get("price"));
    // int availability = Integer.parseInt((String)
    // requestBody.get("availability"));

    // // TODO: Replace with real ticketimpl from DB if needed
    // TicketImpl dummyTicketImpl = new TicketImpl();

    // Bundling bundling = BundlingFactory.createBundling(
    // "TicketingSystem.bundling.core.BundlingImpl",
    // bundlingName,
    // price,
    // availability,
    // dummyTicketImpl);

    // return bundling;
    // }

    // @Override
    // public Bundling createBundling(Map<String, Object> requestBody, Map<String,
    // Object> response) {
    // return createBundling(requestBody); // Simple delegation
    // }

    @Override
    public Bundling updateBundling(Map<String, Object> body) {
        if (!body.containsKey("id")) {
            throw new NotFoundException("Field 'id' not found in the request body.");
        }
        String idStr = (String) body.get("id");
        UUID id = UUID.fromString(idStr);

        Bundling bundling = bundlingRepository.getObject(id);
        if (bundling == null) {
            throw new NotFoundException("Bundling with id " + id + " not found");
        }

        if (body.containsKey("bundlingName")) {
            String bundlingName = (String) body.get("bundlingName");
            bundling.setBundlingName(bundlingName);
        }

        int price = -1;
        if (body.containsKey("price")) {
            try {
                price = Integer.parseInt((String) body.get("price"));
            } catch (NumberFormatException e) {
                throw new FieldValidationException("Price must be an integer");
            }
        }

        if (price != -1) {
            bundling.setPrice(price);
        }

        int availability = -1;
        if (body.containsKey("availability")) {
            try {
                availability = Integer.parseInt((String) body.get("availability"));
            } catch (NumberFormatException e) {
                throw new FieldValidationException("Availability must be an integer");
            }
        }
        if (availability != -1) {
            bundling.setAvailability(availability);
        }

        bundlingRepository.updateObject(bundling);
        bundling = bundlingRepository.getObject(id);

        return bundling;
    }

    @Override
    public Bundling getBundling(UUID Id) {
        Bundling bundling = bundlingRepository.getObject(Id);
        if (bundling == null) {
            throw new NotFoundException("Bundling with Id " + Id + " not found");
        }
        return bundling;
    }

    // @Override
    // public HashMap<String, Object> getBundlingById(int id) {
    // // You declared UUID id before, but abstract method still uses int
    // // Here we assume int → UUID mapping is handled elsewhere or refactor later
    // throw new UnsupportedOperationException("getBundlingById(int) not
    // implemented. Use UUID instead.");
    // }

    @Override
    public List<Bundling> getAllBundling() {
        List<Bundling> resultList = bundlingRepository.getListObject("bundling_impl", null, null);
        Set<String> uniqueNames = new HashSet<>();
        List<Bundling> uniqueBundlings = new ArrayList<>();
        for (Bundling bundling : resultList) {
            if (uniqueNames.add(bundling.getBundlingName())) {
                uniqueBundlings.add(bundling);
            }
        }
        return uniqueBundlings;
    }

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<Bundling> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
    }

    @Override
    public List<Bundling> deleteBundling(UUID Id) {
        Bundling bundling = bundlingRepository.getObject(Id);
        // TODO: delete ticket
        return getAllBundling();
    }

    @Override
    public void purchase() {
        // TODO: implement this method
    }
}
