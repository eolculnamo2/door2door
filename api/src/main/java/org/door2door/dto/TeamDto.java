package org.door2door.dto;

import java.util.List;
import java.util.UUID;

public class TeamDto {
	private String email;
	private String password;
	private String name;
	private List<ContactDto> contacts;
	private String profile_pic;
	private String website;
	private String description;
	private String address;
	private String city;
	private String state;
	private String zip;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(final List<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getWebsite() { return website; }

	public void setWebsite(String website) { this.website = website; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public String getCity() { return city; }

	public void setCity(String city) { this.city = city; }

	public String getState() { return state; }

	public void setState(String state) { this.state = state; }

	public String getZip() { return zip; }

	public void setZip(String zip) { this.zip = zip; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getProfile_pic() { return profile_pic; }

	public void setProfile_pic(String profile_pic) { this.profile_pic = profile_pic; }
}
