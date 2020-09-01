package org.door2door.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class ContactEntity {
	@Id
	@Column(name="id", unique = true, nullable = false)
	private UUID id;

	@Column(name="email")
	private String fullName;

	@Column(name="phone")
	private String phone;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() { return phone; }

	public void setPhone(String phone) { this.phone = phone; }
}
