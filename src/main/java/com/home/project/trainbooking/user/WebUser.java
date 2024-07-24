package com.home.project.trainbooking.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class WebUser {

	@NotNull(message = "Is required")
	@Size(min = 1, message = "Is required")
	private String firstName;

	@NotNull(message = "Is required")
	@Size(min = 1, message = "Is required")
	private String lastName;

	@NotNull(message = "Is required")
	@Size(min = 1, message = "Is required")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email;

	@NotNull(message = "Is required")
	@Size(min = 1, message = "Is required")
	private String password;

	public WebUser() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
