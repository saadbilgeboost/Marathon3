package com.saad.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String surname;
	@Enumerated(EnumType.STRING)
	private ERole role;
	@Temporal(TemporalType.DATE)
	Date createdDate;
	@Temporal(TemporalType.DATE)
	Date updatedDate;
	boolean enable;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String surname, ERole role, Date createdDate, Date updatedDate, boolean enable) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", role=" + role + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", enable=" + enable + "]";
	}

}
