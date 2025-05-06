package TicketingSystem.socialmedia.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="socialmedia_impl")
@Table(name="socialmedia_impl")
public class SocialMediaImpl extends SocialMediaComponent {

	public SocialMediaImpl(int id, String platform, String username, String url, EventOrganizerImpl eventorganizerimpl) {
		this.id = id;
		this.platform = platform;
		this.username = username;
		this.url = url;
		this.eventorganizerimpl = eventorganizerimpl;
	}

	public SocialMediaImpl(String platform, String username, String url, EventOrganizerImpl eventorganizerimpl) {
		this.id =  id.randomUUID();;
		this.platform = platform;
		this.username = username;
		this.url = url;
		this.eventorganizerimpl = eventorganizerimpl;
	}

	public SocialMediaImpl() { }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> socialmediaMap = new HashMap<String,Object>();
		socialmediaMap.put("id",getId());
		socialmediaMap.put("platform",getPlatform());
		socialmediaMap.put("username",getUsername());
		socialmediaMap.put("url",getUrl());
		socialmediaMap.put("eventorganizerimpl",getEventorganizerimpl());

        return socialmediaMap;
    }

}
