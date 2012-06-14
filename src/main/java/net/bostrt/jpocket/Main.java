package net.bostrt.jpocket;

import java.util.Map;

import net.bostrt.jpocket.properties.SendProperties;


public class Main {

	public static void main(String[] args) {
		SendProperties props = new SendProperties();
		props.addURL("http://www.google.com");
		
		System.out.println(JPocket.authenticate("", ""));
	}
}
