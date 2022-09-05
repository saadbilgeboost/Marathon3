package com.saad.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_subjectdetail")
public class SubjectDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Subject subject;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	private String title;
	@Lob
	private String description;
	private String article;
	@Temporal(TemporalType.DATE)
	Date createdDate;
	@Temporal(TemporalType.DATE)
	Date updatedDate;
	boolean enable;

	public SubjectDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectDetail(Subject subject, User user, String title, String description, String article, Date createdDate,
			Date updatedDate, boolean enable) {
		super();
		this.subject = subject;
		this.user = user;
		this.title = title;
		this.description = description;
		this.article = article;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
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
		return "SubjectDetail [id=" + id + ", subject=" + subject + ", user=" + user + ", title=" + title
				+ ", description=" + description + ", article=" + article + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", enable=" + enable + "]";
	}

}
