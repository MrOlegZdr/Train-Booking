package com.home.project.trainbooking.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "booking_date")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;

	@Column(name = "amount_paid")
	private int amountPaid;

	@Column(name = "ticket_no")
	private int ticketNo;

	@Column(name = "seat_no")
	private String seatNo;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "booking_status_id")
	private BookingStatus bookingStatus;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "departure_station_id")
	private Station departureStation;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "arrival_station_id")
	private Station arrivalStation;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "journey_id")
	private Journey journey;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "carriage_class_id")
	private CarriageClass carriageClass;

	public Booking() {
	}

	public Booking(Date bookingDate, int amountPaid, int ticketNo, String seatNo, Passenger passenger,
			BookingStatus bookingStatus, Station departureStation, Station arrivalStation, Journey journey,
			CarriageClass carriageClass) {
		this.bookingDate = bookingDate;
		this.amountPaid = amountPaid;
		this.ticketNo = ticketNo;
		this.seatNo = seatNo;
		this.passenger = passenger;
		this.bookingStatus = bookingStatus;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.journey = journey;
		this.carriageClass = carriageClass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Station getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	public Station getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(Station arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public CarriageClass getCarriageClass() {
		return carriageClass;
	}

	public void setCarriageClass(CarriageClass carriageClass) {
		this.carriageClass = carriageClass;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", amountPaid=" + amountPaid + ", ticketNo="
				+ ticketNo + ", seatNo=" + seatNo + "]";
	}

}
