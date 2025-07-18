package com.jdev.follow_bus_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lotacao_estimativa", schema = "followbus")
@Getter
@Setter
public class CapacityEstimate {

	@GeneratedValue
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "linha_id")
	private Line line;
	
	@Column(name = "hora", nullable = false)
	private LocalDateTime time;
	
	@Column(name = "dia_semana")
	private int dayOfWeek;
	
	@Column(name = "estimativa_ocupacao_percentual")
	private Double occupancyEstimate;
}
