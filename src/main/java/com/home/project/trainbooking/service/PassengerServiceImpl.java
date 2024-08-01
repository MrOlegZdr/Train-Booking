package com.home.project.trainbooking.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.home.project.trainbooking.entity.Passenger;
import com.home.project.trainbooking.user.WebUser;

public class PassengerServiceImpl implements PassengerService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findByPassengerEmail(String passengerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(WebUser webUser) {
		// TODO Auto-generated method stub

	}

}
