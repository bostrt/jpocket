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
	
	public String getHeader(Header header) {
		return getHeader(header.toString());
	}
	
	public String getHeader(String key) {
		return headers.get(key);
	}
	
	public Map<String, String> getHeaders() {
		return this.headers;
	}
	
	public String getValue(Key key) {
		return this.json.get(key.toString()).toString();
	}
	
	private JSONObject json = null;
	public JSONObject getJSONContent() {
		if(this.json == null) {
			if(this.content instanceof String) {
				this.json = (JSONObject)JSONValue.parse((String)this.content);
			}
		}
		return json;
	}
	
	public enum Key {
		
		USER_SINCE("user_since"),
		COUNT_LIST("count_list"),
		COUNT_UNREAD("count_unread"),
		COUNT_READ("count_read");
		
		private String key;
		
		Key(String key) {
			this.key = key;
		}
		
		@Override
		public String toString() {
			return this.key;
		}
	}
	
	public enum Header {
		
		USER_LIMIT("X-Limit-User-Limit"),
		USER_REMAINING("X-Limit-User-Remaining"),
		USER_RESET_DELAY("X-Limit-User-Reset"),
		
		KEY_LIMIT("X-Limit-Key-Limit"),
		KEY_REMAINING("X-Limit-Key-Remaining"),
		KEY_RESET_DELAY("X-Limit-Key-Reset");
		
		private String header;
		
		Header(String header) {
			this.header = header;
		}
		
		@Override
		public String toString() {
			return this.header;
		}
	}
}
