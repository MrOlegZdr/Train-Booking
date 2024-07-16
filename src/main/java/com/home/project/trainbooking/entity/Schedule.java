package com.home.project.trainbooking.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Journey> journeys;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "carriage_price", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "carriage_class_id"))
	private List<CarriageClass> carriageClasses;

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

	public List<CarriageClass> getCarriageClasses() {
		return carriageClasses;
	}

	public void setCarriageClasses(List<CarriageClass> carriageClasses) {
		this.carriageClasses = carriageClasses;
	}

	public void addCarriageClass(CarriageClass carriageClass) {
		if (carriageClasses == null) {
			carriageClasses = new ArrayList<CarriageClass>();
		}
		carriageClasses.add(carriageClass);
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + "]";
	}

}
