package com.jdev.follow_bus_api.models;

import java.time.OffsetDateTime;
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
@Table(name = "bus_position", schema = "followbus")
@Getter
@Setter
public class BusPosition {
	
	@Id
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "line_id", nullable = false)
	private Line line;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "time", nullable = false)
	private OffsetDateTime time;
	
	@Column(name = "speed_kmh")
	private Double speed;
	
	@Column(name = "license_plate", length = 10)
	private String licensePlate;
	
	@Column(name = "bus_number", length = 20)
	private String busNumber;
	
	
}
