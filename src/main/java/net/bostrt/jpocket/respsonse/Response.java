package net.bostrt.jpocket.respsonse;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Response {
	private int responseCode;
	private String message;
	private Object content;
	private Map<String, String> headers;
	
	public Response(int code, String message, Object content) {
		this.responseCode = code;
		this.message = message;
		this.content = content;
		headers = new HashMap<String, String>();
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getContent() {
		return this.content;
	}
	
	public String toString() {
		return "Status: " + this.responseCode + "\n" +
				this.message;
	}
	
	public void addHeader(String key, String value) {
		headers.put(key, value);
	}
	
	public String getHeader(String key) {
		return headers.get(key);
	}
	
	public Map<String, String> getHeaders() {
		return this.headers;
	}
	
	public JSONObject getJSONContent() {
		System.out.println(this.content.getClass().getName());
		if(this.content instanceof String) {
			return (JSONObject)JSONValue.parse((String)this.content);
		}
		return null;
	}
}
