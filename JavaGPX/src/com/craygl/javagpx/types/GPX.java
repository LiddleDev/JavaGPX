package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.HashSet;

public class GPX {
	
	private String creator;
	private String version;
	
	private Metadata metadata;
	
	private ArrayList<Waypoint> waypoints;
	private ArrayList<Route> routes;
	private ArrayList<Track> tracks;
	
	private Extensions extensions;
	
	public GPX() {
		this.waypoints = new ArrayList<Waypoint>();
		this.tracks = new ArrayList<Track>();
		this.routes = new ArrayList<Route>();
	}
	
	public void addWaypoint(Waypoint wp) {
		if (this.waypoints == null)
			this.waypoints = new ArrayList<Waypoint>();
		
		this.waypoints.add(wp);
	}
	
	public void addRoute(Route route) {
		if (this.routes == null)
			this.routes = new ArrayList<Route>();
		
		this.routes.add(route);
	}
	
	public void addTrack(Track track) {
		if (this.tracks == null)
			this.tracks = new ArrayList<Track>();
		
		this.tracks.add(track);
	}
	
	// SETTERS
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setMetadata(Metadata metadata) { 
		this.metadata = metadata;
	}
	
	public void setWaypoints(ArrayList<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
	
	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	
	// GETTERS

	public String getCreator() {
		return creator;
	}
	
	public String getVersion() {
		return version;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	
	public ArrayList<Waypoint> getWaypoints() {
		return waypoints;
	}
	
	public ArrayList<Route> getRoutes() {
		return routes;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	
	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
}
