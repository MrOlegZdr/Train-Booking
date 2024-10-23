package com.home.project.trainbooking.service;

import java.util.Optional;

import com.home.project.trainbooking.entity.CarriagePrice;

public interface CarriagePriceService {

	public Optional<CarriagePrice> getCarriagePrice(Long scheduleId, Long carriageClassId);

	public CarriagePrice saveCarriagePrice(CarriagePrice carriagePrice);

	public void deleteCarriagePrice(Long scheduleId, Long carriageClassId);
}
