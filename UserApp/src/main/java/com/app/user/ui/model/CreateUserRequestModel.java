/**
 * 
 */
package com.app.user.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Akansh_Rai
 *
 */
public class CreateUserRequestModel {

	@NotNull(message="First name can not be null.")
	@Size(min=3, max=10)
	private String firstName;
	
	@NotNull(message="Last name can not be null.")
	@Size(min=3, max=10)
	private String lastName;
	
	private String password;
	
	@Email(message="Please enter valid password.")
	private String email;

	public CreateUserRequestModel() {}

	/**
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 */
	public CreateUserRequestModel(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Name " + firstName + " " + lastName + " \t email " + email;
	}
}
