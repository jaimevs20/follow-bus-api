package com.jdev.follow_bus_api.models;

import java.time.OffsetDateTime;
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
@Table(name = "veiculo_posicao", schema = "followbus")
@Getter
@Setter
public class BusPosition {
	
	@GeneratedValue
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "linha_id", nullable = false)
	private Line line;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "horario", nullable = false)
	private OffsetDateTime time;
	
	@Column(name = "velocidade_kmh")
	private Double speed;
	
	@Column(name = "placa", length = 10)
	private String licensePlate;
	
	@Column(name = "numero_veiculo", length = 20)
	private String busNumber;
	
	
}
