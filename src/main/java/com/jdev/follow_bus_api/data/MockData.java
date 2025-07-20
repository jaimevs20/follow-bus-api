package com.jdev.follow_bus_api.data;
import java.util.List;

import com.jdev.follow_bus_api.models.BusPosition;
import com.jdev.follow_bus_api.models.Line;

public class MockData {

	private List<Line> lines;
	private List<BusPosition> busPositions;
	
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public List<BusPosition> getBusPositions() {
		return busPositions;
	}
	public void setBusPositions(List<BusPosition> busPositions) {
		this.busPositions = busPositions;
	}
	
	
}
