package com.oasis.poc1.entity;

import java.util.Arrays;

public class OutputJson {
	
	private OutputJsonControl[] data;

	public OutputJsonControl[] getData() {
		return data;
	}

	public void setData(OutputJsonControl[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OutputJson [data=" + Arrays.toString(data) + "]";
	}
	
	
	
	

}
