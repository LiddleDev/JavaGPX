package com.craygl.javagpx.types;

import java.util.ArrayList;
import java.util.Date;

public class Waypoint {
	
	private Double lat;
	private Double lon;
	
	private Float ele;
	private Date time;
	private Float magvar;
	private String name;
	private Float geoidheight;
	private String cmt;
	private String desc;
	private String src;
	private ArrayList<Link> links;
	private String sym;
	private String type;
	private Fix fix;
	private Integer sat;
	private Float hdop;
	private Float vdop;
	private Float pdop;
	private Float ageofgpsdata;
	private Integer dgpsid;
	private Extensions extensions;
	
	public Waypoint(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		
		this.links = new ArrayList<Link>();
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

	public Float getMagvar() {
		return magvar;
	}

	public void setMagvar(Float magvar) {
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

	public Integer getSat() {
		return sat;
	}

	public void setSat(Integer sat) {
		this.sat = sat;
	}

	public Float getHdop() {
		return hdop;
	}

	public void setHdop(Float hdop) {
		this.hdop = hdop;
	}

	public Float getVdop() {
		return vdop;
	}

	public void setVdop(Float vdop) {
		this.vdop = vdop;
	}

	public Float getPdop() {
		return pdop;
	}

	public void setPdop(Float pdop) {
		this.pdop = pdop;
	}

	public Float getAgeofgpsdata() {
		return ageofgpsdata;
	}

	public void setAgeofgpsdata(Float ageofgpsdata) {
		this.ageofgpsdata = ageofgpsdata;
	}

	public Integer getDgpsid() {
		return dgpsid;
	}

	public void setDgpsid(Integer dgpsid) {
		this.dgpsid = dgpsid;
	}
	
	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public Float getGeoidheight() {
		return geoidheight;
	}

	public void setGeoidheight(Float geoidheight) {
		this.geoidheight = geoidheight;
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
