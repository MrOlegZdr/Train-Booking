package com.home.project.trainbooking.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Journey> journeys;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CarriagePrice> carriagePrices;

	public Schedule() {
	}

	public Schedule(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}

	public Set<CarriagePrice> getCarriagePrices() {
		return carriagePrices;
	}

	public void setCarriagePrices(Set<CarriagePrice> carriagePrices) {
		this.carriagePrices = carriagePrices;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + "]";
	}

}
