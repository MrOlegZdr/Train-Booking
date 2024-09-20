package com.home.project.trainbooking.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CarriagePricePK implements Serializable {

	private static final long serialVersionUID = -8547475151332615182L;

	private Long scheduleId;
	private Long carriageClassId;

	public CarriagePricePK() {
	}

	public CarriagePricePK(Long scheduleId, Long carriageClassId) {
		this.scheduleId = scheduleId;
		this.carriageClassId = carriageClassId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getCarriageClassId() {
		return carriageClassId;
	}

	public void setCarriageClassId(Long carriageClassId) {
		this.carriageClassId = carriageClassId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carriageClassId, scheduleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarriagePricePK other = (CarriagePricePK) obj;
		return Objects.equals(carriageClassId, other.carriageClassId) && Objects.equals(scheduleId, other.scheduleId);
	}

	@Override
	public String toString() {
		return "CarriagePricePK [scheduleId=" + scheduleId + ", carriageClassId=" + carriageClassId + "]";
	}

}
