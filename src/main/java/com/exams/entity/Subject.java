package com.exams.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 25.07.2017.
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String title;

	@OneToMany(orphanRemoval = true, mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<Exam> exams = new HashSet<>();

	public Subject(String title) {
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
