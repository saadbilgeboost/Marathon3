package com.saad.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	@ManyToOne
	private Lesson lesson;
	@Temporal(TemporalType.DATE)
	Date createdDate;
	@Temporal(TemporalType.DATE)
	Date updatedDate;
	boolean enable;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String name, Lesson lesson, Date createdDate, Date updatedDate, boolean enable) {
		super();
		this.name = name;
		this.lesson = lesson;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enable = enable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", lesson=" + lesson + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", enable=" + enable + "]";
	}

}
