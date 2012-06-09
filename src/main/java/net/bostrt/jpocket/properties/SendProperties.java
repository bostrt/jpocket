package net.bostrt.jpocket.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONValue;

public class SendProperties 
{
	private List<HashMap<String, String>> newUrls;
	private List<HashMap<String, String>> read;
	private List<HashMap<String, String>> updateTags;

	public SendProperties() {
		newUrls = new ArrayList<HashMap<String,String>>(); 
		read = new ArrayList<HashMap<String, String>>();
		updateTags = new ArrayList<HashMap<String, String>>();
	}
	
	public SendProperties addURL(String url) {
		return addURL(url, url);
	}
	
	public SendProperties addURL(String url, String title) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("url", url);
		map.put("title", title);
		newUrls.add(map);
		
		return this;
	}
	
	public SendProperties updateTags(String url, String tags) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("url", url);
		map.put("tags", tags);
		updateTags.add(map);
		
		return this;
	}
	
	public SendProperties editTitle(String url, String title) {
		return null;
	}
	
	public SendProperties markRead(String url) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("url", url);
		read.add(map);
		
		return this;
	}
	
	public String encodeNewUrls() {
		if(newUrls.isEmpty()){
			return "";
		}
		
		return "new=" + JSONValue.toJSONString(newUrls);
	}
	
	public String encodeRead() {
		if(read.isEmpty()){
			return "";
		}
		return "read=" + JSONValue.toJSONString(read);
	}
	
	public String encodeEditTags() {
		if(updateTags.isEmpty()){
			return "";
		}
		return "update_tags=" + JSONValue.toJSONString(updateTags);
	}
}
