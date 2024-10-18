package com.home.project.trainbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

	Optional<Station> findByStationName(String stationName);
}
