package TicketingSystem..rating;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import TicketingSystem.rating.Rating;
import vmj.auth.annotations.Restricted;
//add other required packages

public class Rating extends Rating{
	protected Rating record;

	// @Restriced(permission = "")
	
    @Route(url="call/rating/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Rating rating = createRating(vmjExchange);
		ratingRepository.saveObject(rating);
		return getAllRating(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String userIdStr = (String) vmjExchange.getRequestBodyForm("userId");
		int userId = Integer.parseInt(userIdStr);
		String scoreStr = (String) vmjExchange.getRequestBodyForm("score");
		int score = Integer.parseInt(scoreStr);
		String comment = (String) vmjExchange.getRequestBodyForm("comment");
		String timeStamp = (String) vmjExchange.getRequestBodyForm("timeStamp");
		
		//to do: fix association attributes
		
		Rating rating = RatingFactory.createRating("TicketingSystem.rating.core.Rating", userId, score, comment, timeStamp);
			return rating;
	}

    // @Restriced(permission = "")
    @Route(url="call/rating/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("userId");
		int id = Integer.parseInt(idStr);
		
		Rating rating = ratingRepository.getObject(id);
		String userIdStr = (String) vmjExchange.getRequestBodyForm("userId");
		rating.setUserId(Integer.parseInt(userIdStr));
		String scoreStr = (String) vmjExchange.getRequestBodyForm("score");
		rating.setScore(Integer.parseInt(scoreStr));
		rating.setComment((String) vmjExchange.getRequestBodyForm("comment"));
		rating.setTimeStamp((String) vmjExchange.getRequestBodyForm("timeStamp"));
		
		ratingRepository.updateObject(rating);
		rating = ratingRepository.getObject(id);
		//to do: fix association attributes
		
		return rating.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("userId"); 
		int id = Integer.parseInt(idStr);
		Rating rating = ratingRepository.getObject(id);
		return rating.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Rating> ratingList = ratingRepository.getAllObject("rating_impl");
		return transformRatingListToHashMap(ratingList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/delete")
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("userId");
		int id = Integer.parseInt(idStr);
		ratingRepository.deleteObject(id);
		return getAllRating(vmjExchange);
	}

}
