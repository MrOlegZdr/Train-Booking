package com.home.project.trainbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.home.project.trainbooking.entity.CarriagePrice;
import com.home.project.trainbooking.entity.CarriagePricePK;
import com.home.project.trainbooking.repository.CarriagePriceRepository;

import jakarta.transaction.Transactional;

public class CarriagePriceServiceImpl implements CarriagePriceService {

	@Autowired
	CarriagePriceRepository carriagePriceRepository;

	@Override
	public Optional<CarriagePrice> getCarriagePrice(Long scheduleId, Long carriageClassId) {
		CarriagePricePK id = new CarriagePricePK(scheduleId, carriageClassId);
		return carriagePriceRepository.findById(id);
	}

	@Override
	@Transactional
	public CarriagePrice saveCarriagePrice(CarriagePrice carriagePrice) {
		return carriagePriceRepository.save(carriagePrice);
	}

	@Override
	@Transactional
	public void deleteCarriagePrice(Long scheduleId, Long carriageClassId) {
		CarriagePricePK id = new CarriagePricePK(scheduleId, carriageClassId);
		carriagePriceRepository.deleteById(id);
	}

}
