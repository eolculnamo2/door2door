package org.door2door.dto;

import java.util.List;

public class OrganizationDto {
	private String name;
	private List<UserDto> users;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(final List<UserDto> users) {
		this.users = users;
	}
}
