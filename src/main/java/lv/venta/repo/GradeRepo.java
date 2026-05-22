package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface GradeRepo extends CrudRepository<Grade, Long> {

}
