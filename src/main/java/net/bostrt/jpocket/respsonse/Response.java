package net.bostrt.jpocket.respsonse;

import java.util.HashMap;
import java.util.Map;

public class Response {
	private int responseCode;
	private String message;
	private Map<String, String> headers;
	
	public Response(int code, String message) {
		this.responseCode = code;
		this.message = message;
		headers = new HashMap<String, String>();
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	
	public String getMessage() {
		return message;
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
}
