package com.home.project.trainbooking.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.home.project.trainbooking.entity.Passenger;
import com.home.project.trainbooking.user.WebUser;

public interface PassengerService extends UserDetailsService {

	public Passenger findByPassengerEmail(String passengerEmail);

	void save(WebUser webUser);
}
