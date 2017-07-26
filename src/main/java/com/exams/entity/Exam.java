package com.exams.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by sanya on 25.07.2017.
 */
@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer mark;

	@Column(nullable = false)
	private LocalDate createDate;

	@Override
	public String toString() {
		return "Exam{" +
				"id=" + id +
				", mark=" + mark +
				", createDate=" + createDate +
				'}';
	}

	@ManyToOne
	private Subject subject;

	public Exam() {
	}

	public Exam(Integer mark, LocalDate createDate, Subject subject) {
		this.mark = mark;
		this.createDate = createDate;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
