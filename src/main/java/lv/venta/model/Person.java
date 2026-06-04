package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Person {
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
}
