package com.oasis.poc1.entity;

public class TileFeatures {
	
	private TileAttributes attributes;
	private Geometry geometry;	

	public TileAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(TileAttributes attributes) {
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
		return "TileFeatures [attributes=" + attributes + ", geometry=" + geometry + "]";
	}
	
	
	
	
	
	
	
	
}
