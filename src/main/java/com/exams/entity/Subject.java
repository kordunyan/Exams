package com.exams.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 25.07.2017.
 */
@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String title;

	@OneToMany(orphanRemoval = true, mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<Exam> exams = new HashSet<>();

	public Subject() {
	}

	public Subject(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
