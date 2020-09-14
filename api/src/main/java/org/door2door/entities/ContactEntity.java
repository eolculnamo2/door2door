package org.door2door.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "contacts")
public class ContactEntity {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private UUID id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone")
	private String phone;

	@ManyToOne
	@JoinColumn(name = "contact_fk")
	@JsonBackReference
	private TeamEntity team;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getPhone() { return phone; }

	public void setPhone(String phone) { this.phone = phone; }

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(final TeamEntity teamEntity) {
		this.team = teamEntity;
	}
}
