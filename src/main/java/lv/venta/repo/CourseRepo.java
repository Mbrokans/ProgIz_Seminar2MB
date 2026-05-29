package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;
import lv.venta.model.Degree;

public interface CourseRepo extends CrudRepository<Course, Long>{

	boolean existsByTitle(String title);

	ArrayList<Course> findByProfessorDegree(Degree degree);

}
