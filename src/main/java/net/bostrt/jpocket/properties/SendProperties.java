package net.bostrt.jpocket.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONValue;

public class SendProperties 
{
	private List<HashMap<String, String>> newUrls;
	private List<HashMap<String, String>> read;
	

	public SendProperties() {
		newUrls = new ArrayList<HashMap<String,String>>(); 
		read = new ArrayList<HashMap<String, String>>();
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
	
	public SendProperties editTags(String url, String tags) {
		return null;
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
		return "new=" + JSONValue.toJSONString(newUrls);
	}
	
	public String encodeRead() {
		return "read=" + JSONValue.toJSONString(read);
	}
}
