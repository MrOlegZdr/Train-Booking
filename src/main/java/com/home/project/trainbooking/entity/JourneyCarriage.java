package com.home.project.trainbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "journey_carriage")
public class JourneyCarriage {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "journey_id")
	private Journey journey;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "carriage_class_id")
	private CarriageClass carriageClass;

	@NotNull
	@Column(name = "position")
	private int position;

	public JourneyCarriage() {
	}

	public JourneyCarriage(Journey journey, CarriageClass carriageClass, @NotNull int position) {
		this.journey = journey;
		this.carriageClass = carriageClass;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public CarriageClass getCarriageClass() {
		return carriageClass;
	}

	public void setCarriageClass(CarriageClass carriageClass) {
		this.carriageClass = carriageClass;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "JourneyCarriage [id=" + id + ", journey=" + journey + ", carriageClass=" + carriageClass + ", position="
				+ position + "]";
	}

}
