package com.home.project.trainbooking.entity;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "carriage_class")
public class CarriageClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "class_name")
	private String className;

	@Column(name = "seating_capacity")
	private String seatingCapacity;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "carriage_price", joinColumns = @JoinColumn(name = "carriage_class_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
	private List<Schedule> schedules;

	public CarriageClass() {
	}

	public CarriageClass(String className, String seatingCapacity) {
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

	public String getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public void addSchedule(Schedule schedule) {
		if (schedules == null) {
			schedules.add(schedule);
		}
	}

	@Override
	public String toString() {
		return "CarriageClass [id=" + id + ", className=" + className + ", seatingCapacity=" + seatingCapacity + "]";
	}

}
