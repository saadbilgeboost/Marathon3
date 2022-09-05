package com.saad.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private SubjectDetail subjectDetail;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	String title;
	String question;
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedDate;
	boolean enable;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(SubjectDetail subjectDetail, User user, String title, String question, Date createdDate,
			Date updatedDate, boolean enable) {
		super();
		this.subjectDetail = subjectDetail;
		this.user = user;
		this.title = title;
		this.question = question;
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

	public SubjectDetail getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(SubjectDetail subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
		return "Question [id=" + id + ", subjectDetail=" + subjectDetail + ", user=" + user + ", title=" + title
				+ ", question=" + question + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", enable=" + enable + "]";
	}

}
