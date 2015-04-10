package com.craygl.javagpx.types;

public class Person {
	/*
	 * <name> xsd:string </name> [0..1] ?
<email> emailType </email> [0..1] ?
<link> linkType </link> [0..1] ?
	 */
	
	private String name;
	private Email email;
	private Link link;
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}
	
	
}
