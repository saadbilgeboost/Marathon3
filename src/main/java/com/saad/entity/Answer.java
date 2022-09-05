package com.saad.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Question question;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	String answer;
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedDate;
	boolean enable;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(Question question, User user, String answer, Date createdDate, Date updatedDate, boolean enable) {
		super();
		this.question = question;
		this.user = user;
		this.answer = answer;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		return "Answer [id=" + id + ", question=" + question + ", user=" + user + ", answer=" + answer
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", enable=" + enable + "]";
	}

}
