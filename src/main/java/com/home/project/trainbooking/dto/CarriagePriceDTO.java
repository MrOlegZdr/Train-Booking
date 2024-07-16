package com.home.project.trainbooking.dto;

public class CarriagePriceDTO {

	private int scheduleId;
	private int carriageClassId;
	private int price;

	public CarriagePriceDTO() {
	}

	public CarriagePriceDTO(int scheduleId, int carriageClassId, int price) {
		this.scheduleId = scheduleId;
		this.carriageClassId = carriageClassId;
		this.price = price;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getCarriageClassId() {
		return carriageClassId;
	}

	public void setCarriageClassId(int carriageClassId) {
		this.carriageClassId = carriageClassId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarriagePriceDTO [scheduleId=" + scheduleId + ", carriageClassId=" + carriageClassId + ", price="
				+ price + "]";
	}

}
