package TicketingSystem.bundling.core;

import java.util.*;
import vmj.routing.route.VMJExchange;
import TicketingSystem.bundling.BundlingFactory;
import TicketingSystem.ticket.core.TicketImpl;

public class BundlingServiceImpl extends BundlingServiceComponent {

    @Override
    public List<HashMap<String, Object>> saveBundling(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }

        Map<String, Object> requestBody = vmjExchange.getPayload();
        Bundling bundling = createBundling(requestBody);

        Repository.saveObject(bundling);
        return getAllBundling(requestBody);
    }

    @Override
    public Bundling createBundling(Map<String, Object> requestBody) {
        String bundlingName = (String) requestBody.get("bundlingName");
        int price = Integer.parseInt((String) requestBody.get("price"));
        int availability = Integer.parseInt((String) requestBody.get("availability"));

        // TODO: Replace with real ticketimpl from DB if needed
        TicketImpl dummyTicketImpl = new TicketImpl(); 

        Bundling bundling = BundlingFactory.createBundling(
            "TicketingSystem.bundling.core.BundlingImpl",
            bundlingName,
            price,
            availability,
            dummyTicketImpl
        );

        return bundling;
    }

    @Override
    public Bundling createBundling(Map<String, Object> requestBody, Map<String, Object> response) {
        return createBundling(requestBody); // Simple delegation
    }

    @Override
    public HashMap<String, Object> updateBundling(Map<String, Object> requestBody) {
        UUID id = UUID.fromString((String) requestBody.get("id"));
        Bundling bundling = Repository.getObject(id);

        if (bundling instanceof BundlingComponent) {
            BundlingComponent component = (BundlingComponent) bundling;

            component.setBundlingName((String) requestBody.get("bundlingName"));
            component.setPrice(Integer.parseInt((String) requestBody.get("price")));
            component.setAvailability(Integer.parseInt((String) requestBody.get("availability")));
        }

        Repository.updateObject(bundling);
        return bundling.toHashMap();
    }

    @Override
    public HashMap<String, Object> getBundling(Map<String, Object> requestBody) {
        List<HashMap<String, Object>> bundlingList = getAllBundling(requestBody);
        String idStr = (String) requestBody.get("id");

        for (HashMap<String, Object> bundling : bundlingList) {
            if (bundling.get("id").equals(idStr)) {
                return bundling;
            }
        }
        return null;
    }

    @Override
    public HashMap<String, Object> getBundlingById(int id) {
        // You declared UUID id before, but abstract method still uses int
        // Here we assume int → UUID mapping is handled elsewhere or refactor later
        throw new UnsupportedOperationException("getBundlingById(int) not implemented. Use UUID instead.");
    }

    @Override
    public List<HashMap<String, Object>> getAllBundling(Map<String, Object> requestBody) {
        String table = (String) requestBody.get("table_name");
        List<Bundling> list = Repository.getAllObject(table);
        return transformListToHashMap(list);
    }

    @Override
    public List<HashMap<String, Object>> transformListToHashMap(List<Bundling> list) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (Bundling bundling : list) {
            resultList.add(bundling.toHashMap());
        }
        return resultList;
    }

    @Override
    public List<HashMap<String, Object>> deleteBundling(Map<String, Object> requestBody) {
        UUID id = UUID.fromString((String) requestBody.get("id"));
        Repository.deleteObject(id);
        return getAllBundling(requestBody);
    }

    @Override
    protected void purchase() {
        System.out.println("purchase() called in service; this should ideally be in entity logic.");
    }
}
