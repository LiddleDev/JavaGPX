package com.craygl.javagpx.types;

import java.util.Date;

public class Point {
	
	private Double lat;
	private Double lon;
	private Float ele;
	private Date time;
	
	public Point(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Float getEle() {
		return ele;
	}

	public void setEle(Float ele) {
		this.ele = ele;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
