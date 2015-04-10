package com.craygl.javagpx.types;

import java.net.URI;

public class Link {
	
	private URI href;
	private String text;
	private String type;
	
	public Link(URI href) {
		this.href = href;
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
