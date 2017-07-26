package com.exams.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by sanya on 25.07.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer mark;

	@Column(nullable = false)
	private LocalDate createDate;

	@ManyToOne
	private Subject subject;

	public Exam(Integer mark, LocalDate createDate, Subject subject) {
		this.mark = mark;
		this.createDate = createDate;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"id=" + id +
				", mark=" + mark +
				", createDate=" + createDate +
				'}';
	}
}
