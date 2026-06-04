package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@Table(name="CourseTable")
@Entity
public class Course {
	@Column(name="Idc")
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idc;
	@Column(name = "Title",unique = true)
	@NotEmpty
	@NotNull
	@Pattern(regexp="[A-Z]{1}[A-Za-z0-9 ]{3,40}")
	private String title;
	@Column(name="CP")
	@Min(1)
	@Max(40)
	private int creditpoints;
	@JoinColumn(name="Idp")
	@OneToOne
	private Professors professor;
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<>();
	
	public Course(String title, int creditpoints, Professors professor) {
		setTitle(title);
		setCreditpoints(creditpoints);
		setProfessor(professor);
	}
}
