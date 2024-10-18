package com.home.project.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
