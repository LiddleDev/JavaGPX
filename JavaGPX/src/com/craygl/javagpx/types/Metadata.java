package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.Date;

public class Metadata {
	/*<name> xsd:string </name> [0..1] ?
<desc> xsd:string </desc> [0..1] ?
<author> personType </author> [0..1] ?
<copyright> copyrightType </copyright> [0..1] ?
<link> linkType </link> [0..*] ?
<time> xsd:dateTime </time> [0..1] ?
<keywords> xsd:string </keywords> [0..1] ?
<bounds> boundsType </bounds> [0..1] ?
<extensions> extensionsType </extensions> [0..1] ?*/
	
	private String name;
	private String desc;
	private Person author;
	private Copyright copyright;
	private ArrayList<Link> links;
	private Date time;
	private String keywords;
	private Bounds bounds;
	private Extensions extensions;
	
	public Metadata() {
		links = new ArrayList<Link>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Copyright getCopyright() {
		return copyright;
	}

	public void setCopyright(Copyright copyright) {
		this.copyright = copyright;
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}
	
	public void addLink(Link link) {
		this.links.add(link);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
	
	
}
