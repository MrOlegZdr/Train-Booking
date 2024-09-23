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
@Table(name = "carriage_class")
public class CarriageClass {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "class_name", nullable = false)
	private String className;

	@Column(name = "seating_capacity", nullable = false)
	private int seatingCapacity;

	@OneToMany(mappedBy = "carriageClass", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CarriagePrice> carriagePrices;

	@OneToMany(mappedBy = "carriageClass", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<JourneyCarriage> journeyCarriages;

	@OneToMany(mappedBy = "carriageClass", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Booking> bookings;

	public CarriageClass() {
	}

	public CarriageClass(String className, int seatingCapacity) {
		this.className = className;
		this.seatingCapacity = seatingCapacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Set<CarriagePrice> getCarriagePrices() {
		return carriagePrices;
	}

	public void setCarriagePrices(Set<CarriagePrice> carriagePrices) {
		this.carriagePrices = carriagePrices;
	}

	public List<JourneyCarriage> getJourneyCarriages() {
		return journeyCarriages;
	}

	public void setJourneyCarriages(List<JourneyCarriage> journeyCarriages) {
		this.journeyCarriages = journeyCarriages;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "CarriageClass [id=" + id + ", className=" + className + ", seatingCapacity=" + seatingCapacity + "]";
	}

}
