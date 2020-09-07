package org.door2door.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "team")
public class TeamEntity {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private UUID id;

	@Column(name="email")
	private String email;

	@Column(name="website")
	private String website;

	@Column(name="description")
	private String description;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="zip")
	private String zip;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="contacts")
	private List<ContactEntity> contacts;

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<ContactEntity> getContacts() {
		return contacts;
	}

	public void setContacts(final List<ContactEntity> users) {
		this.contacts = contacts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPassword() { return password; }

	public void setPassword(String password) {
		this.password = password;
	}
}
