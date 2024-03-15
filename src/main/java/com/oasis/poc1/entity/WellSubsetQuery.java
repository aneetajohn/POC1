package com.oasis.poc1.entity;

import java.util.List;

public class WellSubsetQuery {

	private List<WellLayer> layers;

	public List<WellLayer> getLayers() {
		return layers;
	}

	public void setLayers(List<WellLayer> layers) {
		this.layers = layers;
	}

	@Override
	public String toString() {
		return "WellSubsetQuery [layers=" + layers + "]";
	}

	
	
}
