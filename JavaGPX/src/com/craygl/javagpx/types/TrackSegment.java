package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.HashSet;

public class TrackSegment {
	
	private ArrayList<Waypoint> waypoints;
	private Extensions extensions;
	
	public TrackSegment() {
		this.waypoints = new ArrayList<Waypoint>();
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
