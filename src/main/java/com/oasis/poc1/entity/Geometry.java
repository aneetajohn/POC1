package com.oasis.poc1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Geometry {

	private List<List<Double []>> rings;

	private Double x;
	
	private Double y;
	
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}


	
	public List<List<Double[]>> getRings() {
		return rings;
	}
	public void setRings(List<List<Double[]>> rings) {
		this.rings = rings;
	}
	
	@Override
	public String toString() {
		return "Geometry [rings=" + rings + ", x=" + x + ", y=" + y + "]";
	}
	
}
