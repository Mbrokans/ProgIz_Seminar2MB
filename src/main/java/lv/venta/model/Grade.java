package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="GradeTable") // ja strategija ir single table tas attiecas uz visiem kur it atseviski tables
@Entity
public class Grade {
	@Column(name="Idg")
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idg;
	@Column(name = "grade")
	@Min(0)
	@Max(10)
	private int grade;
	@ManyToOne
	@JoinColumn(name="Idp")
	private Student student;
	@ManyToOne
	@JoinColumn(name="Idc")
	private Course course;
	public Grade(int grade, Student student, Course course) {
		setGrade(grade);
		setStudent(student);
		setCourse(course);
	}
}
