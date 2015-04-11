package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.HashSet;

public class Route {
	
	private String name;
	private String cmt;
	private String desc;
	private String src;
	private ArrayList<Link> links;
	private Integer number;
	private String type;
	private Extensions extensions;
	private ArrayList<Waypoint> waypoints;
	
	public Route() {
		this.links = new ArrayList<Link>();
		this.waypoints = new ArrayList<Waypoint>();
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(ArrayList<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
	
	public void addWaypoint(Waypoint waypoint) {
		this.waypoints.add(waypoint);
	}
	
	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
}
