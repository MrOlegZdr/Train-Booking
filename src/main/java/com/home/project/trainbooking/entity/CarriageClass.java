package com.home.project.trainbooking.entity;

import java.util.ArrayList;
import java.util.HashSet;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carriage_class")
public class CarriageClass {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "class_name")
	private String className;

	@NotBlank
	@Column(name = "seating_capacity")
	private int seatingCapacity;

	@OneToMany(mappedBy = "carriageClass", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CarriagePrice> carriagePrices;

	@OneToMany(mappedBy = "carriageClass", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<JourneyCarriage> journeyCarriages;

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

	public void addCarriagePrice(CarriagePrice carriagePrice) {
		if (carriagePrices == null) {
			carriagePrices = new HashSet<>();
		}
		carriagePrices.add(carriagePrice);
		carriagePrice.setCarriageClass(this);
	}

	public List<JourneyCarriage> getJourneyCarriages() {
		return journeyCarriages;
	}

	public void setJourneyCarriages(List<JourneyCarriage> journeyCarriages) {
		this.journeyCarriages = journeyCarriages;
	}

	public void addJourneyCarriage(JourneyCarriage journeyCarriage) {
		if (journeyCarriages == null) {
			journeyCarriages = new ArrayList<>();
		}
		journeyCarriages.add(journeyCarriage);
		journeyCarriage.setCarriageClass(this);
	}

	@Override
	public String toString() {
		return "CarriageClass [id=" + id + ", className=" + className + ", seatingCapacity=" + seatingCapacity + "]";
	}

}
