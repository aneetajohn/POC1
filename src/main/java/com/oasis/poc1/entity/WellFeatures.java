package com.oasis.poc1.entity;

public class WellFeatures {
	
	private WellAttributes attributes;
	private Geometry geometry;
	
	public WellAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(WellAttributes attributes) {
		this.attributes = attributes;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	@Override
	public String toString() {
		return "WellFeatures [attributes=" + attributes + ", geometry=" + geometry + "]";
	}
	
	

}
