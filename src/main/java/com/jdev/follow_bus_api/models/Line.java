package com.jdev.follow_bus_api.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "line", schema = "followbus")
@Getter
@Setter
public class Line {
	
	@Id
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "code", nullable = false, length = 20)
	private String code;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "direction", length = 50)
	private String direction;
	
	@Column(name = "active")
	private Boolean active;
	
	@OneToMany(mappedBy = "line")
	private List<LineStop> stops; 
	
	@OneToMany(mappedBy = "line")
	private List<BusPosition> positions;
	
	@OneToMany(mappedBy = "line")
	private List<BusHistory> histories;
	
	@OneToMany(mappedBy = "line")
	private List<CapacityEstimate> capacities;

}
