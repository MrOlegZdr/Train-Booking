package com.home.project.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.project.trainbooking.entity.CarriagePrice;
import com.home.project.trainbooking.entity.CarriagePricePK;

public interface CarriagePriceRepository extends JpaRepository<CarriagePrice, CarriagePricePK> {

}
