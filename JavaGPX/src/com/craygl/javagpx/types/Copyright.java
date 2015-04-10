package com.craygl.javagpx.types;

import java.net.URI;
import java.util.Date;

public class Copyright {
	
	private String author;
	private Date year;
	private URI license;
	
	public Copyright(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public URI getLicense() {
		return license;
	}

	public void setLicense(URI license) {
		this.license = license;
	}
	
	
}
