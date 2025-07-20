package com.jdev.follow_bus_api.models;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stop", schema = "followbus", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"latitude", "longitude"}))
@Getter
@Setter
public class Stop {

	@Id
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "latitude", nullable = false)
	private Double latitude;
	
	@Column(name = "longitude", nullable = false)
	private Double longitude;
	
	@OneToMany(mappedBy = "stop")
	private List<LineStop> lines;
	
}
