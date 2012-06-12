package net.bostrt.jpocket.repsonse;

public class Response {
	private int reponseCode;
	private String message;
	
	public Response(int code, String message) {
		this.reponseCode = code;
		this.message = message;
	}
	
	public int getResponseCode() {
		return reponseCode;
	}
	
	public String getMessage() {
		return message;
	}
}
