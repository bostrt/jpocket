package net.bostrt.jpocket;

import java.net.HttpURLConnection;
import java.net.URL;

import net.bostrt.jpocket.properties.SendProperties;
import net.bostrt.jpocket.repsonse.Response;

public class JPocket {
	private static final String username = "";
	private static final String password = "";
	private static final String apiKey = "";
	private static final String baseUrl = "https://readitlaterlist.com/v2/";

	public static Response send(SendProperties props) {
		Auth auth = new Auth(username, password, apiKey);
		return send(props, auth);
	}

	private static Response send(SendProperties props, Auth auth) {
		return send("send", props, auth);
	}
	
	private static Response send(String action, SendProperties props,
			Auth auth) {
		String completeUrl = baseUrl + action + "?"
				+ "username=" + username
				+ "&password=" + password + "&apikey=" + apiKey
				+ props.encodeNewUrls()
				+ props.encodeRead()
				+ props.encodeUpdateTags() 
				+ props.encodeUpdateTitle();

		return makeRequest(completeUrl);
	}

	public static Response signup(String newUsername, String newPassword) {
		String completeUrl = baseUrl + "signup?" 
				+ "username=" + newUsername
				+ "&password=" + newPassword 
				+ "&apikey=" + apiKey;
		
		return makeRequest(completeUrl);
	}
	
	public static Response authenticate(String checkUsername, String checkPassword) {
		String completeUrl = baseUrl + "auth?" 
				+ "username=" + checkUsername 
				+ "&password=" + checkPassword
				+ "&apikey=" + apiKey;
		
		return makeRequest(completeUrl);
	}
	
	private static Response makeRequest(String completeUrl) {
		try {
			URL url = new URL(completeUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			int code = conn.getResponseCode();
			String msg = (code == 200 ? "Success" : conn.getHeaderField("X-Error")); 
			
			Response r = new Response(code, msg);

			conn.disconnect();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

/**
 * This isn't really used right now...it's okay though
 * 
 * @author robert
 *
 */
class Auth {
	public String username;
	public String password;
	public String apiKey;

	public Auth(String u, String p, String a) {
		this.username = u;
		this.password = p;
		this.apiKey = a;
	}
}