package com.craygl.javagpx;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

	private static Track parseTrack(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Route parseRoute(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Metadata parseMetadata(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
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
	
	private static Link parseLink(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Date getDateFromNode(Node node) throws Exception {
		Date val = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		val = sdf.parse(node.getFirstChild().getNodeValue());
		
		return val;
	}
	
	private static Double getDoubleFromNode(Node node) {
		return Double.parseDouble(node.getNodeValue());
	}
	
	private static Float getFloatFromNode(Node node) {
		return Float.parseFloat(node.getNodeValue());
	}

	private static Fix getFixFromNode(Node node) {
		return Fix.getTypeFromString(node.getNodeValue());
	}

	private static Integer getIntegerFromNode(Node node) {
		return Integer.parseInt(node.getFirstChild().getNodeValue());
	}

	private static String getStringFromNode(Node node) {
		if (node == null) {
			return null;
		}

		return node.getNodeValue();
	}

}
