package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Degree;
import lv.venta.model.Professors;

public interface ProfessorRepo extends CrudRepository<Professors, Long> {

	boolean existsByDegree(Degree degree);

}
