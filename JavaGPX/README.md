# JavaGPX

A simple Java GPX parser with no external dependencies

Example Usage:

Printing the latitude and longitude of every waypoint in a GPX file with multiple tracks and tracksegments

``` Java
	File file = new File("C:/test.gpx");
	InputStream stream;
	
	GPX gpx = null;
	
	try {
		stream = new FileInputStream(file);
		gpx = GPXParser.parse(stream);
		stream.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
	ArrayList<Track> tracks = gpx.getTracks();
	for (Track track : tracks) {
		for (TrackSegment trackSegment : track.getTrackSegments()) {
			for (Waypoint waypoint : trackSegment.getWaypoints()) {
				waypoints.add(waypoint);
			}
		}
	}
	for (Waypoint waypoint : waypoints) {
		System.out.println(waypoint.getLat() + ", " + waypoint.getLon());
	}
```

