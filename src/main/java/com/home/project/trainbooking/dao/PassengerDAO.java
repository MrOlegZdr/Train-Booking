package com.home.project.trainbooking.dao;

import com.home.project.trainbooking.entity.Passenger;

public interface PassengerDAO {

	void save(Passenger passenger);

	Passenger findByPassengerEmail(String passengerEmail);
}
