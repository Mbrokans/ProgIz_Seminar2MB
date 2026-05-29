package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{


	ArrayList<Student> findByGradesGradeLessThan(int i);



}
