package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
}
