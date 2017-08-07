package com.exams.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	@OneToMany(orphanRemoval = true, mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Exam> exams = new ArrayList<>();

	@Column
	private Boolean isEnabled;

	public Subject(String title) {
		this.title = title;
	}

	public Subject(String title, Boolean isEnabled) {
		this.title = title;
		this.isEnabled = isEnabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Subject subject = (Subject) o;

		if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
		return title != null ? title.equals(subject.title) : subject.title == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isEnabled=" + isEnabled +
				'}';
	}
}
