package lv.venta.service;
import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Student;

public interface ICRUDfilterservice {
	public abstract ArrayList<Grade> filterGradesByStudentId(long id)throws Exception;
	
	public abstract ArrayList<Grade> filterGradesByCourseTitle(String title)throws Exception;
	
	public abstract ArrayList<Course> filterCoursesByProfessorDegree(Degree degree)throws Exception;
	
	public abstract ArrayList<Student> filterStudentByBadGrades()throws Exception;
}
