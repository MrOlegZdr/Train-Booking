package com.home.project.trainbooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.home.project.trainbooking.entity.CarriagePrice;
import com.home.project.trainbooking.entity.CarriagePricePK;
import com.home.project.trainbooking.repository.CarriagePriceRepository;

@ExtendWith(MockitoExtension.class)
public class CarriagePriceServiceImplTest {

	@Mock
	private CarriagePriceRepository carriagePriceRepository;

	@InjectMocks
	private CarriagePriceServiceImpl carriagePriceService;

	private CarriagePrice carriagePrice;
	private CarriagePricePK id;

	@BeforeEach
	public void setUp() {
		carriagePrice = new CarriagePrice();
		id = new CarriagePricePK(1L, 1L);
		carriagePrice.setId(id);
	}

	@Test
	@DisplayName("Unit test for getCarriagePrice method")
	public void givenScheduleIdCarriageClassId_whenGetCarriagePrice_thenReturnCarriagePriceObject() {

		when(carriagePriceRepository.findById(id)).thenReturn(Optional.of(carriagePrice));

		Optional<CarriagePrice> resultCarriagePrice = carriagePriceService.getCarriagePrice(1L, 1L);

		assertThat(resultCarriagePrice).isNotNull();
	}

	@Test
	@DisplayName("Unit test for saveCarriagePrice method")
	public void givenCarriagePriceObject_whenSaveCarriagePrice_thenReturnCarriagePriceObject() {

		when(carriagePriceRepository.save(carriagePrice)).thenReturn(carriagePrice);

		CarriagePrice savedCarriagePrice = carriagePriceService.saveCarriagePrice(carriagePrice);

		assertThat(savedCarriagePrice).isNotNull();
	}

	@Test
	@DisplayName("Unit test for deleteCarriagePrice method")
	public void givenScheduleIdCarriageClassId_whenDeleteCarriagePrice_thenNothing() {

		doNothing().when(carriagePriceRepository).deleteById(id);

		carriagePriceService.deleteCarriagePrice(1L, 1L);

		verify(carriagePriceRepository, times(1)).deleteById(id);
	}

}
