package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professors;

public interface ProfessorRepo extends CrudRepository<Professors, Long> {

}
