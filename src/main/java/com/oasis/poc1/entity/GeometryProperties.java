package com.oasis.poc1.entity;

public class GeometryProperties {
	
	private String shapeAreaFieldName;
	private String shapeLengthFieldName;
	
	public String getShapeAreaFieldName() {
		return shapeAreaFieldName;
	}
	public void setShapeAreaFieldName(String shapeAreaFieldName) {
		this.shapeAreaFieldName = shapeAreaFieldName;
	}
	public String getShapeLengthFieldName() {
		return shapeLengthFieldName;
	}
	public void setShapeLengthFieldName(String shapeLengthFieldName) {
		this.shapeLengthFieldName = shapeLengthFieldName;
	}
	
	@Override
	public String toString() {
		return "GeometryProperties [shapeAreaFieldName=" + shapeAreaFieldName + ", shapeLengthFieldName="
				+ shapeLengthFieldName + "]";
	}
	
	
	
	

}
