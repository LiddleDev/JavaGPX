package com.craygl.javagpx.types;

import java.util.HashSet;

public class GPX {
	
	private String creator;
	private String version;
	
	private Metadata metadata;
	
	private HashSet<Waypoint> waypoints;
	private HashSet<Route> routes;
	private HashSet<Track> tracks;
	
	private Extensions extensions;
	
	public GPX() {
		this.waypoints = new HashSet<Waypoint>();
		this.tracks = new HashSet<Track>();
		this.routes = new HashSet<Route>();
	}
	
	public void addWaypoint(Waypoint wp) {
		if (this.waypoints == null)
			this.waypoints = new HashSet<Waypoint>();
		
		this.waypoints.add(wp);
	}
	
	public void addRoute(Route route) {
		if (this.routes == null)
			this.routes = new HashSet<Route>();
		
		this.routes.add(route);
	}
	
	public void addTrack(Track track) {
		if (this.tracks == null)
			this.tracks = new HashSet<Track>();
		
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
	
	public void setWaypoints(HashSet<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
	
	public void setRoutes(HashSet<Route> routes) {
		this.routes = routes;
	}
	
	public void setTracks(HashSet<Track> tracks) {
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
	
	public HashSet<Waypoint> getWaypoints() {
		return waypoints;
	}
	
	public HashSet<Route> getRoutes() {
		return routes;
	}
	
	public HashSet<Track> getTracks() {
		return tracks;
	}
	
	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
}
