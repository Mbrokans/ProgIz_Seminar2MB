package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface GradeRepo extends CrudRepository<Grade, Long> {

	ArrayList<Grade> findByStudentIds(long id);

	ArrayList<Grade> findByCourseTitle(String title);


}
