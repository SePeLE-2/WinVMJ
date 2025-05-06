package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SocialMediaResourceComponent implements SocialMediaResource{
	
	public SocialMediaResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange);
    public abstract SocialMedia createSocialMedia(VMJExchange vmjExchange);
	public abstract SocialMedia createSocialMedia(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateSocialMedia(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getSocialMedia(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllSocialMedia(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteSocialMedia(VMJExchange vmjExchange);

}
