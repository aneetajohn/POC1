package com.oasis.poc1.entity;

public class SpatialReference {
	
	private Integer wkid;
	private Integer latestWkid;
	
	public Integer getWkid() {
		return wkid;
	}
	public void setWkid(Integer wkid) {
		this.wkid = wkid;
	}
	public Integer getLatestWkid() {
		return latestWkid;
	}
	public void setLatestWkid(Integer latestWkid) {
		this.latestWkid = latestWkid;
	}
	
	@Override
	public String toString() {
		return "SpatialReference [wkid=" + wkid + ", latestWkid=" + latestWkid + "]";
	}
	
	

}
