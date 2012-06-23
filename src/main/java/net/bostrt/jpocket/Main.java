package net.bostrt.jpocket;

import net.bostrt.jpocket.respsonse.Response;
import net.bostrt.jpocket.respsonse.Response.Key;

import org.json.simple.JSONObject;


public class Main {

	public static void main(String[] args) {
		Response r = JPocket.stats();
		JSONObject o = r.getJSONContent();
		System.out.println(r.getMessage());
		System.out.println(r.getValue(Key.COUNT_LIST));
	}
}
