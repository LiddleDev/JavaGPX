package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.Date;

public class Waypoint {
	
	private double latitude;
	private double longitude;
	
	private double elevation;
	private Date time;
	private double magvar;
	private String name;
	private double geoidHeight;
	private String cmt;
	private String desc;
	private String src;
	private ArrayList<Link> links;
	private String sym;
	private String type;
	private Fix fix;
	private int sat;
	private double hdop;
	private double vdop;
	private double pdop;
	private double ageOfGPSData;
	private int dgpsid;
	private Extensions extensions;
	
	public Waypoint(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		
		this.links = new ArrayList<Link>();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getMagvar() {
		return magvar;
	}

	public void setMagvar(double magvar) {
		this.magvar = magvar;
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

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public double getHdop() {
		return hdop;
	}

	public void setHdop(double hdop) {
		this.hdop = hdop;
	}

	public double getVdop() {
		return vdop;
	}

	public void setVdop(double vdop) {
		this.vdop = vdop;
	}

	public double getPdop() {
		return pdop;
	}

	public void setPdop(double pdop) {
		this.pdop = pdop;
	}

	public double getAgeOfGPSData() {
		return ageOfGPSData;
	}

	public void setAgeOfGPSData(double ageOfGPSData) {
		this.ageOfGPSData = ageOfGPSData;
	}

	public int getDgpsid() {
		return dgpsid;
	}

	public void setDgpsid(int dgpsid) {
		this.dgpsid = dgpsid;
	}
	
	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public double getGeoidHeight() {
		return geoidHeight;
	}

	public void setGeoidHeight(double geoidHeight) {
		this.geoidHeight = geoidHeight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Fix getFix() {
		return fix;
	}

	public void setFix(Fix fix) {
		this.fix = fix;
	}
	
	
}
