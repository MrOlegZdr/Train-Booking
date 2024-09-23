package com.home.project.trainbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "carriage_price")
public class CarriagePrice {

	@EmbeddedId
	private CarriagePricePK id;

	@ManyToOne
	@MapsId("scheduleId")
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@ManyToOne
	@MapsId("carriageClassId")
	@JoinColumn(name = "carriage_class_id")
	private CarriageClass carriageClass;

	@Column(name = "price", nullable = false)
	private int price;

	public CarriagePrice() {
	}

	public CarriagePrice(Schedule schedule, CarriageClass carriageClass, int price) {
		this.schedule = schedule;
		this.carriageClass = carriageClass;
		this.price = price;
	}

	public CarriagePricePK getId() {
		return id;
	}

	public void setId(CarriagePricePK id) {
		this.id = id;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public CarriageClass getCarriageClass() {
		return carriageClass;
	}

	public void setCarriageClass(CarriageClass carriageClass) {
		this.carriageClass = carriageClass;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarriagePrice [id=" + id + ", price=" + price + "]";
	}

}
