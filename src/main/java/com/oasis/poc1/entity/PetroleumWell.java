package com.oasis.poc1.entity;

import java.util.List;

public class PetroleumWell {

	private List<Layers> layers;

	public List<Layers> getLayers() {
		return layers;
	}

	public void setLayers(List<Layers> layers) {
		this.layers = layers;
	}

	@Override
	public String toString() {
		return "PetroleumWell [layers=" + layers + "]";
	}
	
	
}
