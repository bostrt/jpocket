package net.bostrt.jpocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.bostrt.jpocket.properties.SendProperties;
import net.bostrt.jpocket.respsonse.Response;

public class JPocket 
{
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
	
	public static boolean authenticate(String checkUsername, String checkPassword) {
		String completeUrl = baseUrl + "auth?" 
				+ "username=" + checkUsername 
				+ "&password=" + checkPassword
				+ "&apikey=" + apiKey;
		
		return makeRequest(completeUrl).getResponseCode() == 200;
	}
	
	public static Response api(boolean userLimits) {
		String completeUrl = baseUrl + "api?"
				+ "&apikey=" + apiKey;
		
		if(userLimits) {
			completeUrl += "&username=" + username 
				+ "&password=" + password;
		}
		
		List<String> extraHeaders = new ArrayList<String>();
		extraHeaders.add(Response.Header.USER_LIMIT.toString());
		extraHeaders.add(Response.Header.USER_REMAINING.toString());
		extraHeaders.add(Response.Header.USER_RESET_DELAY.toString());
		extraHeaders.add(Response.Header.KEY_LIMIT.toString());
		extraHeaders.add(Response.Header.KEY_REMAINING.toString());
		extraHeaders.add(Response.Header.KEY_RESET_DELAY.toString());
		
		return makeRequest(completeUrl, extraHeaders);
	}
	
	public static Response stats() {
		String completeUrl = baseUrl + "stats?"
				+ "username=" + username + "&"
				+ "password=" + password + "&"
				+ "apikey=" + apiKey;
		
		return makeRequest(completeUrl);
	}
	
	private static Response makeRequest(String completeUrl) {
		return makeRequest(completeUrl, null);
	}
	
	private static Response makeRequest(String completeUrl, List<String> extraHeaders) {
		try {
			URL url = new URL(completeUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			int code = conn.getResponseCode();
			
			String msg = (code == 200 ? "Success" : conn.getHeaderField("X-Error")); 

			String content = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				content += inputLine;
			}
			reader.close();
			
			Response r = new Response(code, msg, content);
			
			if(extraHeaders != null) {
				for(String header : extraHeaders) {
					r.addHeader(header, conn.getHeaderField(header));
				}
			}

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