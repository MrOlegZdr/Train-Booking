package com.home.project.trainbooking.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class JourneyStationPK implements Serializable {

	private static final long serialVersionUID = -5849141119527134289L;

	private Long journeyId;
	private Long stationId;

	public JourneyStationPK() {
	}

	public JourneyStationPK(Long journeyId, Long stationId) {
		this.journeyId = journeyId;
		this.stationId = stationId;
	}

	public Long getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(Long journeyId) {
		this.journeyId = journeyId;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(journeyId, stationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JourneyStationPK other = (JourneyStationPK) obj;
		return Objects.equals(journeyId, other.journeyId) && Objects.equals(stationId, other.stationId);
	}

	@Override
	public String toString() {
		return "JourneyStationPK [journeyId=" + journeyId + ", stationId=" + stationId + "]";
	}

}
