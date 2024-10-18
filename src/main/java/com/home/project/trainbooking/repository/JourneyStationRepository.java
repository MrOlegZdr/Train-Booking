package com.home.project.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.JourneyStation;
import com.home.project.trainbooking.entity.JourneyStationPK;

public interface JourneyStationRepository extends JpaRepository<JourneyStation, JourneyStationPK> {

}
