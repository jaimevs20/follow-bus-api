package com.jdev.follow_bus_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdev.follow_bus_api.models.CapacityEstimate;

public interface CapacityEstimateRepository extends JpaRepository<CapacityEstimate, UUID> {

}
