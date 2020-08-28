package org.door2door.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization")
public class OrganizationEntity {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private UUID id;

	@Column(name="name")
	private String name;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="organization")
	private List<UserEntity> users;

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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(final List<UserEntity> users) {
		this.users = users;
	}
}
