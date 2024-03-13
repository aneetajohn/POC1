package com.oasis.poc1.entity;

public class Features {
	
	private Attributes attributes;
	private Geometry geometry;
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
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
		return "Features [attributes=" + attributes + ", geometry=" + geometry + "]";
	}
	
	
	
	
	
	
	
	
}
