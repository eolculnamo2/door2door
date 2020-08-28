package org.door2door.dto;

import java.util.List;

public class NewOrganizationDto {
	private String name;
	private List<NewUserDto> users;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<NewUserDto> getUsers() {
		return users;
	}

	public void setUsers(final List<NewUserDto> users) {
		this.users = users;
	}
}
