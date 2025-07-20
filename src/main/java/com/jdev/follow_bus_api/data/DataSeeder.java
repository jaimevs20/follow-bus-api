package com.jdev.follow_bus_api.data;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdev.follow_bus_api.models.Line;
import com.jdev.follow_bus_api.models.LineStop;
import com.jdev.follow_bus_api.models.Stop;
import com.jdev.follow_bus_api.repositories.LineRepository;
import com.jdev.follow_bus_api.repositories.LineStopRepository;
import com.jdev.follow_bus_api.repositories.StopRepository;

@Component
public class DataSeeder implements CommandLineRunner{

	@Autowired
	private LineStopRepository lineStopRepository;
	@Autowired
	private LineRepository lineRepository;
	@Autowired
	private StopRepository stopRepository;
	
	@Override
	public void run(String... args) throws Exception {
		InputStream is = DataSeeder.class.getResourceAsStream("/mock_salvador_gtfs.json");
		String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
		
		ObjectMapper objectMapper = new ObjectMapper();
		MockData mockData = objectMapper.readValue(json, MockData.class);
		
		stopRepository.deleteAll();
		lineRepository.deleteAll();
		lineStopRepository.deleteAll();
		
		
		List<Line> lines = new ArrayList<>();
		Map<UUID, Stop> mapStop = new HashMap<>();
		Map<UUID, LineStop> mapLineStop = new HashMap<>();
		
		
		for(Line line : mockData.getLines()) {
			Line lineObj = new Line();
			lineObj.setId(line.getId());
			lineObj.setName(line.getName());
			lineObj.setDirection(line.getDirection());
			lineObj.setCode(line.getCode());
			lineObj.setActive(line.getActive());
			
			lineRepository.save(lineObj);
			
			lineObj.setStops(line.getStops());
			
			lines.add(lineObj);
		}
		

		
		for(Line line : lines) {
			for(LineStop lineStop : line.getStops()) {
				LineStop lineStopObj = new LineStop();
				lineStopObj.setLine(line);
				lineStopObj.setId(lineStop.getId());
				lineStopObj.setLineup(lineStop.getLineup());
				
				Stop stopObj = new Stop();
				stopObj.setId(lineStop.getStop().getId());
				stopObj.setLatitude(lineStop.getStop().getLatitude());
				stopObj.setLongitude(lineStop.getStop().getLongitude());
				stopObj.setName(lineStop.getStop().getName());
				
				mapStop.put(stopObj.getId(), stopObj);
				lineStopObj.setStop(stopObj);
				mapLineStop.put(lineStopObj.getId(), lineStopObj);
			}
		}
		
		stopRepository.saveAll(mapStop.values());
		lineStopRepository.saveAll(mapLineStop.values());
	}

}
