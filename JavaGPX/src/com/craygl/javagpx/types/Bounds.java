package com.craygl.javagpx.types;

public class Bounds {

	private double minimumLatitude;
	private double minimumLongitude;
	private double maximumLatitude;
	private double maximumLongitude;
	
	public Bounds(double minimumLatitude, double minimumLongitude, double maximumLatitude, double maximumLongitude) {
		this.minimumLatitude = minimumLatitude;
		this.minimumLongitude = minimumLongitude;
		this.maximumLatitude = maximumLatitude;
		this.maximumLongitude = maximumLongitude;
	}

	public double getMinimumLatitude() {
		return minimumLatitude;
	}

	public void setMinimumLatitude(double minimumLatitude) {
		this.minimumLatitude = minimumLatitude;
	}

	public double getMinimumLongitude() {
		return minimumLongitude;
	}

	public void setMinimumLongitude(double minimumLongitude) {
		this.minimumLongitude = minimumLongitude;
	}

	public double getMaximumLatitude() {
		return maximumLatitude;
	}

	public void setMaximumLatitude(double maximumLatitude) {
		this.maximumLatitude = maximumLatitude;
	}

	public double getMaximumLongitude() {
		return maximumLongitude;
	}

	public void setMaximumLongitude(double maximumLongitude) {
		this.maximumLongitude = maximumLongitude;
	}
	
	
}
