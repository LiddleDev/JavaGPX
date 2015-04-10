package com.craygl.javagpx.types;

import java.util.HashSet;

public class TrackSegment {
	
	private HashSet<Waypoint> waypoints;
	private Extensions extensions;
	
	public TrackSegment() {
		this.waypoints = new HashSet<Waypoint>();
	}

	public HashSet<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(HashSet<Waypoint> waypoints) {
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
