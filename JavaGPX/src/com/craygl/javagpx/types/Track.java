package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.HashSet;

public class Track {
	
	private String name;
	private String cmt;
	private String desc;
	private String src;
	private ArrayList<Link> links;
	private int number;
	private String type;
	private Extensions extensions;
	private ArrayList<TrackSegment> trackSegments;
	
	public Track() {
		this.links = new ArrayList<Link>();
		this.trackSegments = new ArrayList<TrackSegment>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<TrackSegment> getTrackSegments() {
		return trackSegments;
	}

	public void setTrackSegments(ArrayList<TrackSegment> trackSegments) {
		this.trackSegments = trackSegments;
	}
	
	public void addTrackSegment(TrackSegment trackSegment) {
		this.trackSegments.add(trackSegment);
	}

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
}
