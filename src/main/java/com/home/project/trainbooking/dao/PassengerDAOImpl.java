package com.home.project.trainbooking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.project.trainbooking.entity.Passenger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

	private EntityManager entityManager;

	@Autowired
	public PassengerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Passenger passenger) {

		entityManager.merge(passenger);
	}

	@Override
	public Passenger findByPassengerEmail(String passengerEmail) {

		// retrieve/read from database using passengerEmail
		TypedQuery<Passenger> theQuery = entityManager.createQuery("from Passenger where email=:pEmail",
				Passenger.class);
		theQuery.setParameter("pEmail", passengerEmail);

		Passenger passenger = null;
		try {
			passenger = theQuery.getSingleResult();
		} catch (Exception e) {
			passenger = null;
		}

		return passenger;
	}

}
