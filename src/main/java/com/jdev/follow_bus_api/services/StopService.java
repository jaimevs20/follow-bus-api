package com.jdev.follow_bus_api.services;

import org.springframework.stereotype.Service;

import com.jdev.follow_bus_api.repositories.StopRepository;

@Service
public class StopService {

	private final StopRepository stopRepository;
	
	public StopService(StopRepository stopRepository) {
		this.stopRepository = stopRepository;
	}
}
