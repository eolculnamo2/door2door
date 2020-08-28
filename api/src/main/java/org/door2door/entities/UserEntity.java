package org.door2door.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@ManyToOne
	@JoinColumn(name="user_fk")
	private OrganizationEntity organization;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(final OrganizationEntity organization) {
		this.organization = organization;
	}
}
