package com.craygl.javagpx;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.craygl.javagpx.types.*;

public class GPXParser {

	public static GPX parse(String gpxAsUTF8String) throws InvalidGPXException {
		return parse(new ByteArrayInputStream(
				gpxAsUTF8String.getBytes(StandardCharsets.UTF_8)));
	}

	public static GPX parse(InputStream in) throws InvalidGPXException {
		DocumentBuilder builder;
		Document doc;
		
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(in);
		} catch (Exception e) {
			throw new InvalidGPXException(e);
		}
		

		Node gpxNode = doc.getFirstChild();

		if (gpxNode != null && gpxNode.getNodeName().equalsIgnoreCase(GPXConstants.GPX_NODE)) {
			
			GPX gpx = new GPX();
			
			NamedNodeMap attrs = gpxNode.getAttributes();
			
			for (int i = 0; i < attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				
				if (GPXConstants.VERSION_ATTR.equals(attr.getNodeName())) {
					gpx.setVersion(attr.getNodeValue());
				} else if (GPXConstants.CREATOR_ATTR.equals(attr.getNodeName())) {
					gpx.setCreator(attr.getNodeValue());
				}
			}
			
			if (gpx.getCreator() == null || gpx.getVersion() == null) {
				throw new InvalidGPXException("GPX files must have a creator and version attribute");
			}
			
			NodeList nodes = gpxNode.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node currentNode = nodes.item(i);
				
				switch (currentNode.getNodeName()) {
				case GPXConstants.METADATA_NODE:
					Metadata metadata = parseMetadata(currentNode);
					if (metadata != null) {
						gpx.setMetadata(metadata);
					}
					break;
				case GPXConstants.WPT_NODE:
					Waypoint waypoint = parseWaypoint(currentNode);
					if (waypoint != null) {
						gpx.addWaypoint(waypoint);
					}
					break;
				case GPXConstants.RTE_NODE:
					Route route = parseRoute(currentNode);
					if (route != null) {
						gpx.addRoute(route);
					}
					break;
				case GPXConstants.TRK_NODE:
					Track track = parseTrack(currentNode);
					if (track != null) {
						gpx.addTrack(track);
					}
					break;
				case GPXConstants.EXTENSIONS_NODE:
					gpx.setExtensions(new Extensions(currentNode));
					break;
				}
			}
			
			return gpx;
			
		} else {
			throw new InvalidGPXException("Invalid GPX file, please check the GPX node to make sure it is valid");
		}
	}

	private static Track parseTrack(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.TRK_NODE)) {
			return null;
		}
		
		Track track = new Track();
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.NAME_NODE:
				track.setName(getStringFromNode(currentNode));
				break;
			case GPXConstants.CMT_NODE:
				track.setCmt(getStringFromNode(currentNode));
				break;
			case GPXConstants.DESC_NODE:
				track.setDesc(getStringFromNode(currentNode));
				break;
			case GPXConstants.SRC_NODE:
				track.setSrc(getStringFromNode(currentNode));
				break;
			case GPXConstants.LINK_NODE:
				Link link = parseLink(currentNode);
				if (link != null) {
					track.addLink(link);
				}
				break;
			case GPXConstants.NUMBER_NODE:
				track.setNumber(getIntegerFromNode(currentNode));
				break;
			case GPXConstants.TYPE_NODE:
				track.setType(getStringFromNode(currentNode));
				break;
			case GPXConstants.EXTENSIONS_NODE:
				track.setExtensions(new Extensions(currentNode));
				break;
			case GPXConstants.TRKSEG_NODE:
				TrackSegment trackSegment = parseTrackSegment(currentNode);
				if (trackSegment != null) {
					track.addTrackSegment(trackSegment);
				}
				break;
			}
		}
		
		return track;
	}

	private static TrackSegment parseTrackSegment(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.TRKSEG_NODE)) {
			return null;
		}
		
		TrackSegment trackSegment = new TrackSegment();
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.TRKPT_NODE:
				Waypoint waypoint = parseWaypoint(currentNode);
				if (waypoint != null) {
					trackSegment.addWaypoint(waypoint);
				}
				break;
			case GPXConstants.EXTENSIONS_NODE:
				trackSegment.setExtensions(new Extensions(currentNode));
				break;
			}
		}
		
		return trackSegment;
	}

	private static Route parseRoute(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.RTE_NODE)) {
			return null;
		}
		
		Route route = new Route();
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.NAME_NODE:
				route.setName(getStringFromNode(currentNode));
				break;
			case GPXConstants.CMT_NODE:
				route.setCmt(getStringFromNode(currentNode));
				break;
			case GPXConstants.DESC_NODE:
				route.setDesc(getStringFromNode(currentNode));
				break;
			case GPXConstants.SRC_NODE:
				route.setSrc(getStringFromNode(currentNode));
				break;
			case GPXConstants.LINK_NODE:
				Link link = parseLink(currentNode);
				if (link != null) {
					route.addLink(link);
				}
				break;
			case GPXConstants.NUMBER_NODE:
				route.setNumber(getIntegerFromNode(currentNode));
				break;
			case GPXConstants.TYPE_NODE:
				route.setType(getStringFromNode(currentNode));
				break;
			case GPXConstants.EXTENSIONS_NODE:
				route.setExtensions(new Extensions(currentNode));
				break;
			case GPXConstants.RTEPT_NODE:
				Waypoint waypoint = parseWaypoint(currentNode);
				if (waypoint != null) {
					route.addWaypoint(waypoint);
				}
				break;
			}
		}
		
		return route;
	}

	private static Metadata parseMetadata(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.METADATA_NODE)) {
			return null;
		}
		
		Metadata metadata = new Metadata();
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.NAME_NODE:
				metadata.setName(getStringFromNode(currentNode));
				break;
			case GPXConstants.DESC_NODE:
				metadata.setDesc(getStringFromNode(currentNode));
				break;
			case GPXConstants.AUTHOR_NODE:
				Person author = parsePerson(currentNode);
				if (author != null) {
					metadata.setAuthor(author);
				}
				break;
			case GPXConstants.COPYRIGHT_NODE:
				Copyright copyright = parseCopyright(currentNode);
				if (copyright != null) {
					metadata.setCopyright(copyright);
				}
				break;
			case GPXConstants.LINK_NODE:
				Link link = parseLink(currentNode);
				if (link != null) {
					metadata.addLink(link);
				}
				break;
			case GPXConstants.TIME_NODE:
				try {
					metadata.setTime(getDateFromNode(currentNode));
				} catch (Exception e) {
					throw new InvalidGPXException(e);
				}
				break;
			case GPXConstants.KEYWORDS_NODE:
				metadata.setKeywords(getStringFromNode(currentNode));
				break;
			case GPXConstants.BOUNDS_NODE:
				Bounds bounds = parseBounds(currentNode);
				if (bounds != null) {
					metadata.setBounds(bounds);
				}
				break;
			case GPXConstants.EXTENSIONS_NODE:
				metadata.setExtensions(new Extensions(currentNode));
				break;
			}
		}
		
		return metadata;
	}

	private static Bounds parseBounds(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.BOUNDS_NODE)) {
			return null;
		}
		
		NamedNodeMap attrs = node.getAttributes();
		Double minlat = null;
		Double minlon = null;
		Double maxlat = null;
		Double maxlon = null;
		
		for (int i = 0; i < attrs.getLength(); i++) {
			Node attr = attrs.item(i);
			
			if (GPXConstants.MINLAT_ATTR.equals(attr.getNodeName())) {
				minlat = Double.parseDouble(attr.getNodeValue());
			} else if (GPXConstants.MINLON_ATTR.equals(attr.getNodeName())) {
				minlon = Double.parseDouble(attr.getNodeValue());
			} else if (GPXConstants.MAXLAT_ATTR.equals(attr.getNodeName())) {
				maxlat = Double.parseDouble(attr.getNodeValue());
			} else if (GPXConstants.MAXLON_ATTR.equals(attr.getNodeName())) {
				maxlon = Double.parseDouble(attr.getNodeValue());
			}
		}
		
		if (minlat == null || minlon == null || maxlat == null || maxlon == null) {
			throw new InvalidGPXException("Invalid bounds set in GPX file");
		}
		
		Bounds bounds = new Bounds(minlat, minlon, maxlat, maxlon);
		
		return bounds;
	}

	private static Copyright parseCopyright(Node node) throws InvalidGPXException {
		if (!node.getNodeName().equals(GPXConstants.COPYRIGHT_NODE)) {
			return null;
		}
		
		NamedNodeMap attrs = node.getAttributes();
		String author = null;
		
		for (int i = 0; i < attrs.getLength(); i++) {
			Node attr = attrs.item(i);
			
			if (GPXConstants.AUTHOR_ATTR.equals(attr.getNodeName())) {
				author = attr.getNodeValue();
			}
		}
		
		if (author == null) {
			throw new InvalidGPXException("No author attached to the copyright in your metadata");
		}
		
		Copyright copyright = new Copyright(author);
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.YEAR_NODE:
				copyright.setYear(getIntegerFromNode(currentNode));
				break;
			case GPXConstants.LICENSE_NODE:
				URI uri = URI.create(getStringFromNode(currentNode));
				copyright.setLicense(uri);
				break;
			}
		}
		
		return copyright;
	}

	private static Person parsePerson(Node node) throws InvalidGPXException {
		Person person = new Person();
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.NAME_NODE:
				person.setName(getStringFromNode(currentNode));
				break;
			case GPXConstants.EMAIL_NODE:
				Email email = parseEmail(currentNode);
				if (email != null) {
					person.setEmail(email);
				}
				break;
			case GPXConstants.LINK_NODE:
				Link link = parseLink(currentNode);
				if (link != null) {
					person.setLink(link);
				}
				break;
			}
		}
		
		return person;
	}

	private static Email parseEmail(Node node) throws InvalidGPXException {
		/*
		id="xsd:string [1] ?"
		domain="xsd:string [1] ?"/>
		 */
		if (!node.getNodeName().equals(GPXConstants.EMAIL_NODE)) {
			return null;
		}
		
		NamedNodeMap attrs = node.getAttributes();
		String id = null;
		String domain = null;
		
		for (int i = 0; i < attrs.getLength(); i++) {
			Node attr = attrs.item(i);
			
			if (GPXConstants.ID_ATTR.equals(attr.getNodeName())) {
				id = getStringFromNode(attr);
			} else if (GPXConstants.DOMAIN_ATTR.equals(attr.getNodeName())) {
				domain = getStringFromNode(attr);
			}
		}
		
		if (id == null || domain == null) {
			throw new InvalidGPXException("Invalid email in your GPX file");
		}
		
		Email email = new Email(id, domain);
		return email;
	}

	private static Waypoint parseWaypoint(Node node) throws InvalidGPXException{
		NamedNodeMap attrs = node.getAttributes();
		Double lat = null;
		Double lon = null;
		
		for (int i = 0; i < attrs.getLength(); i++) {
			Node attr = attrs.item(i);
			
			if (GPXConstants.LAT_ATTR.equals(attr.getNodeName())) {
				lat = Double.parseDouble(attr.getNodeValue());
			} else if (GPXConstants.LON_ATTR.equals(attr.getNodeName())) {
				lon = Double.parseDouble(attr.getNodeValue());
			}
		}
		
		if (lat == null || lon == null) {
			throw new InvalidGPXException("One of the waypoints does not have a latitude or longitude attribute");
		}
		
		Waypoint waypoint = new Waypoint(lat, lon);
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.ELE_NODE:
				waypoint.setEle(getFloatFromNode(currentNode));
				break;
			case GPXConstants.TIME_NODE:
				try {
					waypoint.setTime(getDateFromNode(currentNode));
				} catch (Exception e) {
					throw new InvalidGPXException(e);
				}
				break;
			case GPXConstants.MAGVAR_NODE:
				waypoint.setMagvar(getFloatFromNode(currentNode));
				break;
			case GPXConstants.GEOIDHEIGHT_NODE:
				waypoint.setGeoidheight(getFloatFromNode(currentNode));
				break;
			case GPXConstants.NAME_NODE:
				waypoint.setName(getStringFromNode(currentNode));
				break;
			case GPXConstants.CMT_NODE:
				waypoint.setCmt(getStringFromNode(currentNode));
				break;
			case GPXConstants.DESC_NODE:
				waypoint.setDesc(getStringFromNode(currentNode));
				break;
			case GPXConstants.SRC_NODE:
				waypoint.setSrc(getStringFromNode(currentNode));
				break;
			case GPXConstants.LINK_NODE:
				Link link = parseLink(currentNode);
				if (link != null) {
					waypoint.addLink(link);
				}
				break;
			case GPXConstants.SYM_NODE:
				waypoint.setSym(getStringFromNode(currentNode));
				break;
			case GPXConstants.TYPE_NODE:
				waypoint.setType(getStringFromNode(currentNode));
				break;
			case GPXConstants.FIX_NODE:
				waypoint.setFix(getFixFromNode(currentNode));
				break;
			case GPXConstants.SAT_NODE:
				waypoint.setSat(getIntegerFromNode(currentNode));
				break;
			case GPXConstants.HDOP_NODE:
				waypoint.setHdop(getFloatFromNode(currentNode));
				break;
			case GPXConstants.VDOP_NODE:
				waypoint.setVdop(getFloatFromNode(currentNode));
				break;
			case GPXConstants.PDOP_NODE:
				waypoint.setPdop(getFloatFromNode(currentNode));
				break;
			case GPXConstants.AGEOFGPSDATA_NODE:
				waypoint.setAgeofgpsdata(getFloatFromNode(currentNode));
				break;
			case GPXConstants.DGPSID_NODE:
				waypoint.setDgpsid(getIntegerFromNode(currentNode));
				break;
			case GPXConstants.EXTENSIONS_NODE:
				waypoint.setExtensions(new Extensions(currentNode));
				break;
			}
		}
		
		return waypoint;
	}
	
	private static Link parseLink(Node node) throws InvalidGPXException {
		/*
		href="xsd:anyURI [1] ?"> 
		<text> xsd:string </text> [0..1] ?
		<type> xsd:string </type> [0..1] ?
		 */
		
		if (!node.getNodeName().equals(GPXConstants.LINK_NODE)) {
			return null;
		}
		
		NamedNodeMap attrs = node.getAttributes();
		URI href = null;
		
		for (int i = 0; i < attrs.getLength(); i++) {
			Node attr = attrs.item(i);
			
			if (GPXConstants.HREF_ATTR.equals(attr.getNodeName())) {
				href = URI.create(attr.getNodeValue());
			}
		}
		
		if (href == null) {
			throw new InvalidGPXException("Invalid link somewhere in GPX file");
		}
		
		Link link = new Link(href);
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node currentNode = nodes.item(i);
			
			switch (currentNode.getNodeName()) {
			case GPXConstants.TEXT_NODE:
				link.setText(getStringFromNode(currentNode));
				break;
			case GPXConstants.TYPE_NODE:
				link.setType(getStringFromNode(currentNode));
				break;
			}
		}
		
		return link;
	}

	private static Date getDateFromNode(Node node) throws Exception {
		if (node.getNodeValue() == null)
			return null;
		
		Date val = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		val = sdf.parse(node.getNodeValue());
		
		return val;
	}
	
	private static Double getDoubleFromNode(Node node) {
		Double d = null;
		if (node.getNodeValue() != null)
			d = Double.parseDouble(node.getNodeValue());
		
		return d;
	}
	
	private static Float getFloatFromNode(Node node) {
		Float f = null;
		if (node.getNodeValue() != null)
			f = Float.parseFloat(node.getNodeValue());
		
		return f;
	}

	private static Fix getFixFromNode(Node node) {
		return Fix.getTypeFromString(node.getNodeValue());
	}

	private static Integer getIntegerFromNode(Node node) {
		Integer i = null;
		if (node.getNodeValue() != null)
			i = Integer.parseInt(node.getNodeValue());
		
		return i;
	}

	private static String getStringFromNode(Node node) {
		return node.getNodeValue();
	}

}
