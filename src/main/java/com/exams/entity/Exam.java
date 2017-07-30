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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Exam exam = (Exam) o;

		if (mark != null ? !mark.equals(exam.mark) : exam.mark != null) return false;
		return createDate != null ? createDate.equals(exam.createDate) : exam.createDate == null;
	}

	@Override
	public int hashCode() {
		int result = mark != null ? mark.hashCode() : 0;
		result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
		return result;
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
