package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name="ProfessorsTable")
@Entity
public class Professors {
	
	@Column(name="Idp")
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;
	@Column(name = "Name")
	@NotEmpty
	@NotNull
	@Pattern(regexp="[A-Z]{1}[a-z]{2,40}([ ]{1}([A-Z]{1}[a-z]{2,40}))?")
	private String name;
	@Column(name = "Surname")
	@NotEmpty
	@NotNull
	@Pattern(regexp="[A-Z]{1}[a-z]{2,40}([ -]{1}([A-Z]{1}[a-z]{2,40}))?")
	private String surname;
	@Column(name = "Degree")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Degree degree;
	@ManyToMany(mappedBy="professors")
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();
	
	public Professors(String name, String surname, Degree degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
	public void addCourse(Course course) {
		if(!courses.contains(course)) {
			courses.add(course);
		}
	}
}
