package com.jdev.follow_bus_api.models;

import java.math.BigInteger;
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
@Table(name = "line_stop", schema = "followbus")
@Getter
@Setter
public class LineStop {
	
	@Id
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "line_id", nullable = false)
	private Line line;
	
	@ManyToOne
	@JoinColumn(name = "stop_id", nullable = false)
	private Stop stop;
	
	@Column(name = "lineup", nullable = false)
	private BigInteger lineup;
}