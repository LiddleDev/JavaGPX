package com.craygl.javagpx.types;

public class Bounds {
	/*minlat="latitudeType [1] ?"
minlon="longitudeType [1] ?"
maxlat="latitudeType [1] ?"
maxlon="longitudeType [1] ?"/>*/
	
	private Double minlat;
	private Double minlon;
	private Double maxlat;
	private Double maxlon;
	
	public Bounds(double minlat, double minlon, double maxlat, double maxlon) {
		this.minlat = minlat;
		this.minlon = minlon;
		this.maxlat = maxlat;
		this.maxlon = maxlon;
	}

	public Double getMinlat() {
		return minlat;
	}

	public void setMinlat(Double minlat) {
		this.minlat = minlat;
	}

	public Double getMinlon() {
		return minlon;
	}

	public void setMinlon(Double minlon) {
		this.minlon = minlon;
	}

	public Double getMaxlat() {
		return maxlat;
	}

	public void setMaxlat(Double maxlat) {
		this.maxlat = maxlat;
	}

	public Double getMaxlon() {
		return maxlon;
	}

	public void setMaxlon(Double maxlon) {
		this.maxlon = maxlon;
	}
	
	
}
