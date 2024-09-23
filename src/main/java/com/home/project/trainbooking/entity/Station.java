package com.home.project.trainbooking.entity;

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
@Table(name = "station")
public class Station {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "station_name", nullable = false)
	private String stationName;

	@OneToMany(mappedBy = "station", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<JourneyStation> journeyStations;

	@OneToMany(mappedBy = "departureStation", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Booking> departures;

	@OneToMany(mappedBy = "arrivalStation", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Booking> arrivals;

	public Station() {
	}

	public Station(String stationName) {
		this.stationName = stationName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Set<JourneyStation> getJourneyStations() {
		return journeyStations;
	}

	public void setJourneyStations(Set<JourneyStation> journeyStations) {
		this.journeyStations = journeyStations;
	}

	public Set<Booking> getDepartures() {
		return departures;
	}

	public void setDepartures(Set<Booking> departures) {
		this.departures = departures;
	}

	public Set<Booking> getArrivals() {
		return arrivals;
	}

	public void setArrivals(Set<Booking> arrivals) {
		this.arrivals = arrivals;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationName=" + stationName + "]";
	}

}
