package com.craygl.javagpx.types;

public enum Fix {
	NONE,
	_2D,
	_3D,
	DGPS,
	PPS;
	
	@Override
	public String toString() {
		switch (this) {
		case NONE:
			return "none";
		case _2D:
			return "2d";
		case _3D:
			return "3d";
		case DGPS:
			return "dgps";
		case PPS:
			return "pps";
		}
		return null;
	}

	public static Fix getTypeFromString(String string) {
		switch (string) {
		case "none":
			return NONE;
		case "2d":
			return _2D;
		case "3d":
			return _3D;
		case "dgps":
			return DGPS;
		case "pps":
			return PPS;
		}
		return null;
	}
}
