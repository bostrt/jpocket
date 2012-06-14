package net.bostrt.jpocket;

import java.util.Map;

import net.bostrt.jpocket.properties.SendProperties;


public class Main {

	public static void main(String[] args) {
		SendProperties props = new SendProperties();
		props.addURL("http://www.google.com");
		
		//Response r = JPocket.send(props);
		Map<String, String> headers = JPocket.api(true).getHeaders();
		for(String key : headers.keySet()) {
			System.out.println(key + " => " + headers.get(key));
		}	
	}
}
