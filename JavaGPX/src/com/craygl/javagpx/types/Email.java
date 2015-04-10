package com.craygl.javagpx.types;

public class Email {
	private String id;
	private String domain;
	
	public Email(String id, String domain) {
		this.id = id;
		this.domain = domain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
}
