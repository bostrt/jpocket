package net.bostrt.jpocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import net.bostrt.jpocket.properties.SendProperties;

public class JPocket {
	private static final String username = "";
	private static final String password = "";
	private static final String apiKey = "";
	private static final String baseUrl = "https://readitlaterlist.com/v2/";

	public static void send(SendProperties props) {
		Auth auth = new Auth(username, password, apiKey);
		send(props, auth);
	}

	private static void send(SendProperties props, Auth auth) {
		makeRequest("send", props, auth);
	}
	
	private static void makeRequest(String action, SendProperties props,
			Auth auth) {
		String completeUrl = baseUrl + action + "?" + "username=" + username
				+ "&password=" + password + "&apikey=" + apiKey + "&"
				+ props.encodeNewUrls() + "&"
				+ props.encodeRead() + "&"
				+ props.encodeEditTags();

		try {
			URL url = new URL(completeUrl);
			URLConnection conn = url.openConnection();

			BufferedReader input = new BufferedReader(
									new InputStreamReader(
											conn.getInputStream()));

			String response = "";

			while ((response = input.readLine()) != null) {
				System.out.println(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

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