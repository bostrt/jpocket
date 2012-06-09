package net.bostrt.jpocket;

import net.bostrt.jpocket.properties.SendProperties;

public class Main {

	public static void main(String[] args) {
		SendProperties props = new SendProperties();
		props.updateTags("http://www.yahoo.com", "foo,bar");
		
		JPocket.send(props);
	}
}
