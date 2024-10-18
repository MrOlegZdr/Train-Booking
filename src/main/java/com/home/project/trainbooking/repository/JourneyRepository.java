package com.home.project.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.Journey;

public interface JourneyRepository extends JpaRepository<Journey, Long> {

}
