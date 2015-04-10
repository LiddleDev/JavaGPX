package com.craygl.javagpx;

/*
 * http://www.topografix.com/GPX/1/1/
 * All repeated values are commented out
 */
public class GPXConstants {
	
	// Parent node
	public static final String GPX_NODE = "gpx";
	
	/*GPX nodes and attributes*/
	public static final String VERSION_ATTR = "version";
	public static final String CREATOR_ATTR = "creator";
	public static final String METADATA_NODE = "metadata";
	public static final String RTE_NODE = "rte";
	public static final String WPT_NODE = "wpt";
	public static final String TRK_NODE = "trk";
	public static final String EXTENSIONS_NODE = "extensions";
	/*End GPX nodes and attributes*/
	
	/*Metadata nodes*/
	public static final String NAME_NODE = "name";
	public static final String DESC_NODE = "desc";
	public static final String AUTHOR_NODE = "author";
	public static final String COPYRIGHT_NODE = "copyright";
	public static final String LINK_NODE = "link";
	public static final String TIME_NODE = "time";
	public static final String KEYWORDS_NODE = "keywords";
	public static final String BOUNDS_NODE = "bounds";
	//public static final String EXTENSIONS_NODE = "extensions";
	/*End Metadata nodes*/
	
	/*Waypoint nodes and attributes*/
	public static final String LAT_ATTR = "lat";
	public static final String LON_ATTR = "lon";
	public static final String ELE_NODE = "ele";
	//public static final String TIME_NODE = "time";
	//public static final String NAME_NODE = "name";
	public static final String CMT_NODE = "cmt";
	//public static final String DESC_NODE = "desc";
	public static final String SRC_NODE = "src";
	public static final String MAGVAR_NODE = "magvar";
	public static final String GEOIDHEIGHT_NODE = "geoidheight";
	//public static final String LINK_NODE = "link";
	public static final String SYM_NODE = "sym";
	public static final String TYPE_NODE = "type";
	public static final String FIX_NODE = "fix";
	public static final String SAT_NODE = "sat";
	public static final String HDOP_NODE = "hdop";
	public static final String VDOP_NODE = "vdop";
	public static final String PDOP_NODE = "pdop";
	public static final String AGEOFGPSDATA_NODE = "ageofdgpsdata";
	public static final String DGPSID_NODE = "dgpsid";
	//public static final String EXTENSIONS_NODE = "extensions";
	/*End Waypoint nodes and attributes*/
	
	/*Route Nodes*/
	//public static final String NAME_NODE = "name";
	//public static final String CMT_NODE = "cmt";
	//public static final String DESC_NODE = "desc";
	//public static final String SRC_NODE = "src";
	public static final String NUMBER_NODE = "number";
	//public static final String TYPE_NODE = "type";
	//public static final String EXTENSIONS_NODE = "extensions";
	public static final String RTEPT_NODE = "rtept";
	/*End route nodes*/
	
	/*Track nodes and attributes*/
	//public static final String CMT_NODE = "cmt";
	//public static final String DESC_NODE = "desc";
	//public static final String SRC_NODE = "src";
	//public static final String LINK_NODE = "link";
	//public static final String NUMBER_NODE = "number";
	//public static final String TYPE_NODE = "type";
	//public static final String EXTENSIONS_NODE = "extensions";
	public static final String TRKSEG_NODE = "trkseg";
	/*End Track nodes and attributes*/
	
	/*Track Segment nodes*/
	public static final String TRKPT_NODE = "trkpt";
	//public static final String EXTENSIONS_NODE = "extensions";
	/*End Track Segment nodes*/
	
	/*Copyright nodes and attributes*/
	public static final String AUTHOR_ATTR = "author";
	public static final String YEAR_NODE = "year";
	public static final String LICENSE_NODE = "license";
	/*End Copyright nodes and attributes*/
	
	/*Link nodes and attributes*/
	public static final String HREF_ATTR = "href";
	public static final String TEXT_NODE = "text";
	//public static final String TYPE_NODE = "type";
	/*Link nodes and attributes*/
	
	/*Email attributes*/
	public static final String ID_ATTR = "id";
	public static final String DOMAIN_ATTR = "domain";
	/*End Email attributes*/
	
	/*Person nodes*/
	//public static final String NAME_NODE = "name";
	public static final String EMAIL_NODE = "email";
	//public static final String LINK_NODE = "link";
	/*End Person nodes*/
	
	/*Point nodes and attributes*/
	//public static final String LAT_ATTR = "lat";
	//public static final String LON_ATTR = "lon";
	//public static final String ELE_NODE = "ele";
	//public static final String TIME_NODE = "time";
	/*End Point nodes and attributes*/
	
	/*Point Segment nodes*/
	public static final String PT_NODE = "pt";
	/*End Point Segment nodes*/
	
	/*Bounds attributes*/
	public static final String MINLAT_ATTR = "minlat";
	public static final String MINLON_ATTR = "minlon";
	public static final String MAXLAT_ATTR = "maxlat";
	public static final String MAXLON_ATTR = "maxlon";
	/*End Bounds attributes*/
}
