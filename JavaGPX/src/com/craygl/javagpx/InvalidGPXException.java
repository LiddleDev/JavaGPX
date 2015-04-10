package com.craygl.javagpx;

public class InvalidGPXException extends Exception {
	public InvalidGPXException(String message) {
		super(message);
	}
	public InvalidGPXException(Exception e) {
		super(e);
	}
}
