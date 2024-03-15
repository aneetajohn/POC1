package com.oasis.poc1.entity;

import java.util.List;

public class TileSubsetQuery {

	private List<TileLayer> layers;

	public List<TileLayer> getLayers() {
		return layers;
	}

	public void setLayers(List<TileLayer> layers) {
		this.layers = layers;
	}

	@Override
	public String toString() {
		return "TileSubsetQuery [layers=" + layers + "]";
	}
	
	
}
