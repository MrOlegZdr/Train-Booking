package com.home.project.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.BookingStatus;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {

}
