package com.home.project.trainbooking.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class JourneyStation {

	@EmbeddedId
	private JourneyStationPK id;

	@ManyToOne
	@MapsId("journeyId")
	@JoinColumn(name = "journey_id")
	private Journey journey;

	@ManyToOne
	@MapsId("stationId")
	@JoinColumn(name = "station_id")
	private Station station;

	@Column(name = "stop_order", nullable = false)
	private int stopOrder;

	@Column(name = "departure_time")
	@Temporal(TemporalType.TIME)
	private Date departureTime;

	@Column(name = "arrival_time")
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	public JourneyStation() {
	}

	public JourneyStation(Journey journey, Station station, int stopOrder, Date departureTime, Date arrivalTime) {
		this.journey = journey;
		this.station = station;
		this.stopOrder = stopOrder;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public JourneyStationPK getId() {
		return id;
	}

	public void setId(JourneyStationPK id) {
		this.id = id;
	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getStopOrder() {
		return stopOrder;
	}

	public void setStopOrder(int stopOrder) {
		this.stopOrder = stopOrder;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "JourneyStation [id=" + id + ", journey=" + journey + ", station=" + station + ", stopOrder=" + stopOrder
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
