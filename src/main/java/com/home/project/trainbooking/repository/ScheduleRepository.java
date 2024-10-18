package com.home.project.trainbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	Optional<Schedule> findByName(String name);
}
