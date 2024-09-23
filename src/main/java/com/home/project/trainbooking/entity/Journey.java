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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "journey")
public class Journey {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@OneToMany(mappedBy = "journey", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<JourneyCarriage> journeyCarriages;

	@OneToMany(mappedBy = "journey", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<JourneyStation> journeyStations;

	@OneToMany(mappedBy = "journey", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Booking> bookings;

	public Journey() {
	}

	public Journey(String name) {
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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<JourneyCarriage> getJourneyCarriages() {
		return journeyCarriages;
	}

	public void setJourneyCarriages(List<JourneyCarriage> journeyCarriages) {
		this.journeyCarriages = journeyCarriages;
	}

	public Set<JourneyStation> getJourneyStations() {
		return journeyStations;
	}

	public void setJourneyStations(Set<JourneyStation> journeyStations) {
		this.journeyStations = journeyStations;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", name=" + name + "]";
	}

}
