package net.bostrt.jpocket;

import net.bostrt.jpocket.properties.SendProperties;

public class Main {

	public static void main(String[] args) {
		SendProperties props = new SendProperties();
		props.addURL("http://www.yahoo.com");
		props.markRead("https://www.github.com");
		
		JPocket.send(props);
	}
}
