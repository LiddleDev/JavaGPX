package com.craygl.javagpx.types;

import java.util.HashSet;

public class PointSegment {
	
	private HashSet<Point> points;
	
	public PointSegment() {
		points = new HashSet<Point>();
	}

	public HashSet<Point> getPoints() {
		return points;
	}

	public void setPoints(HashSet<Point> points) {
		this.points = points;
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
}
