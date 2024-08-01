CREATE DATABASE IF NOT EXISTS `train_booking`;

USE `train_booking`;

SET foreign_key_checks = 0;
DROP TABLE if exists `passenger`;
DROP TABLE if exists `booking`;
DROP TABLE if exists `booking_status`;
DROP TABLE if exists `journey`;
DROP TABLE if exists `station`;
DROP TABLE if exists `journey_station`;
DROP TABLE if exists `schedule`;
DROP TABLE if exists `carriage_class`;
DROP TABLE if exists `carriage_price`;
DROP TABLE if exists `journey_carriage`;
SET foreign_key_checks = 1;

CREATE TABLE `passenger` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(100) NOT NULL,
	`last_name` VARCHAR(100) NOT NULL,
	`email` VARCHAR(100) NOT NULL,
	`password` CHAR(68) NOT NULL,
	CONSTRAINT pk_passenger PRIMARY KEY (`id`));
	
CREATE TABLE `station` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`station_name` VARCHAR(200) NOT NULL,
	CONSTRAINT pk_station PRIMARY KEY (`id`));

CREATE TABLE `booking_status` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	CONSTRAINT pk_bookingstatus PRIMARY KEY (`id`));

CREATE TABLE `schedule` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
	CONSTRAINT pk_schedule PRIMARY KEY (`id`));

CREATE TABLE `carriage_class` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`class_name` VARCHAR(50) NOT NULL,
	`seating_capacity` INT NOT NULL,
	CONSTRAINT pk_carclass PRIMARY KEY (`id`));

CREATE TABLE `journey` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`schedule_id` INT NOT NULL,
	`name` VARCHAR(500) NOT NULL,
	CONSTRAINT pk_journey PRIMARY KEY (`id`),
	CONSTRAINT fk_j_scheudle FOREIGN KEY (`schedule_id`) REFERENCES schedule (`id`));

CREATE TABLE `journey_station` (
	`journey_id` INT NOT NULL,
	`station_id` INT NOT NULL,
	`stop_order` INT NOT NULL,
	`departure_time` DATETIME NOT NULL,
	CONSTRAINT fk_js_journey FOREIGN KEY (`journey_id`) REFERENCES journey (`id`),
	CONSTRAINT fk_js_station FOREIGN KEY (`station_id`) REFERENCES station (`id`));

CREATE TABLE `journey_carriage` (
	`journey_id` INT NOT NULL,
	`carriage_class_id` INT NOT NULL,
	`position` INT NOT NULL,
	CONSTRAINT fk_jc_journey FOREIGN KEY (`journey_id`) REFERENCES journey (`id`),
	CONSTRAINT fk_jc_carclass FOREIGN KEY (`carriage_class_id`) REFERENCES carriage_class (`id`));

CREATE TABLE `carriage_price` (
	`schedule_id` INT NOT NULL,
	`carriage_class_id` INT NOT NULL,
	`price` INT NOT NULL,
	CONSTRAINT fk_carprice_schedule FOREIGN KEY (`schedule_id`) REFERENCES schedule (`id`),
	CONSTRAINT fk_carprice_class FOREIGN KEY (`carriage_class_id`) REFERENCES carriage_class (`id`));

CREATE TABLE `booking` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`passenger_id` INT NOT NULL,
	`status_id` INT NOT NULL,
	`booking_date` DATE NOT NULL,
	`starting_station_id` INT NOT NULL,
	`ending_station_id` INT NOT NULL,
	`journey_id` INT NOT NULL,
	`carriage_class_id` INT NOT NULL,
	`amount_paid` INT,
	`ticket_no` INT NOT NULL,
	`seat_no` VARCHAR(10) NOT NULL,
	CONSTRAINT pk_booking PRIMARY KEY (`id`),
	CONSTRAINT fk_booking_passenger FOREIGN KEY (`passenger_id`) REFERENCES passenger (`id`),
	CONSTRAINT fk_booking_status FOREIGN KEY (`status_id`) REFERENCES booking_status (`id`),
	CONSTRAINT fk_booking_startstn FOREIGN KEY (`starting_station_id`) REFERENCES station (`id`),
	CONSTRAINT fk_booking_endstn FOREIGN KEY (`ending_station_id`) REFERENCES station (`id`),
	CONSTRAINT fk_booking_journey FOREIGN KEY (`journey_id`) REFERENCES journey (`id`),
	CONSTRAINT fk_booking_class FOREIGN KEY (`carriage_class_id`) REFERENCES carriage_class (`id`));
