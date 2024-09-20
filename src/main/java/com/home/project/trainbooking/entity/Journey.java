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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "journey")
public class Journey {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@OneToMany(mappedBy = "journey", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<JourneyCarriage> journeyCarriages;

	public Journey() {
	}

	public Journey(String name, Schedule schedule) {
		this.name = name;
		this.schedule = schedule;
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

	public void addJourneyCarriage(JourneyCarriage journeyCarriage) {
		if (journeyCarriages == null) {
			journeyCarriages = new ArrayList<>();
		}
		journeyCarriages.add(journeyCarriage);
		journeyCarriage.setJourney(this);
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", name=" + name + "]";
	}

}
