package com.jdev.follow_bus_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "capacity_estimate", schema = "followbus")
@Getter
@Setter
public class CapacityEstimate {

	@Id
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "line_id")
	private Line line;
	
	@Column(name = "time", nullable = false)
	private LocalDateTime time;
	
	@Column(name = "day_week")
	private int dayOfWeek;
	
	@Column(name = "occupancy_estimate")
	private Double occupancyEstimate;
}
