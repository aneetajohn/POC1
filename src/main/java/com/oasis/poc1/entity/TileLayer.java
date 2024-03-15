package com.oasis.poc1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TileLayer {
	
	private Integer id;
	private String objectIdFieldName;
	private String globalIdFieldName;
	private String geometryType;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private GeometryProperties geometryProperties;
	private SpatialReference spatialReference;
	private List<Fields> fields;
	private List<TileFeatures> features;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjectIdFieldName() {
		return objectIdFieldName;
	}
	public void setObjectIdFieldName(String objectIdFieldName) {
		this.objectIdFieldName = objectIdFieldName;
	}
	public String getGlobalIdFieldName() {
		return globalIdFieldName;
	}
	public void setGlobalIdFieldName(String globalIdFieldName) {
		this.globalIdFieldName = globalIdFieldName;
	}
	public String getGeometryType() {
		return geometryType;
	}
	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}
	public GeometryProperties getGeometryProperties() {
		return geometryProperties;
	}
	public void setGeometryProperties(GeometryProperties geometryProperties) {
		this.geometryProperties = geometryProperties;
	}
	public SpatialReference getSpatialReference() {
		return spatialReference;
	}
	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}
	public List<Fields> getFields() {
		return fields;
	}
	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}
	public List<TileFeatures> getFeatures() {
		return features;
	}
	public void setFeatures(List<TileFeatures> features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "TileLayer [id=" + id + ", objectIdFieldName=" + objectIdFieldName + ", globalIdFieldName="
				+ globalIdFieldName + ", geometryType=" + geometryType + ", geometryProperties=" + geometryProperties
				+ ", spatialReference=" + spatialReference + ", fields=" + fields + ", features=" + features + "]";
	}
	
	
}
