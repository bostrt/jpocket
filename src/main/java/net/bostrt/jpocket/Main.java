package net.bostrt.jpocket;

import net.bostrt.jpocket.respsonse.Response;

import org.json.simple.JSONObject;


public class Main {

	public static void main(String[] args) {
		Response r = JPocket.stats();
		JSONObject o = r.getJSONContent();
		System.out.println(r.getMessage());
		System.out.println(o.get("user_since"));
	}
}
