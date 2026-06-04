package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Professors extends Person {
	
	@Column(name="Idp")
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;
	@Column(name = "Degree")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Degree degree;
	@OneToOne(mappedBy="professor")
	@ToString.Exclude
	private Course course;
	
	public Professors(String name, String surname, Degree degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
}
