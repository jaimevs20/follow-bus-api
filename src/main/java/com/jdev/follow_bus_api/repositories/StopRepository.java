package com.jdev.follow_bus_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdev.follow_bus_api.models.Stop;

public interface StopRepository extends JpaRepository<Stop, UUID> {

}
