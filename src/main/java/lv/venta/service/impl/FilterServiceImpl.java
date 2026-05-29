package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.CourseRepo;
import lv.venta.repo.GradeRepo;
import lv.venta.repo.ProfessorRepo;
import lv.venta.repo.StudentRepo;
import lv.venta.service.ICRUDfilterservice;
@Service
public class FilterServiceImpl implements ICRUDfilterservice{
	@Autowired
	private StudentRepo studRepo;
	@Autowired
	private GradeRepo gradeRepo;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private ProfessorRepo profRepo;
	@Override
	public ArrayList<Grade> filterGradesByStudentId(long id) throws Exception {
		if(id<1) {
			throw new Exception("ID nevar but negativs");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Students ar tadu "+id+" neeksiste");
		}
		if(gradeRepo.count()==0) {
			throw new Exception("Atzimju tabula ir tuksa un nevaram filtret");
		}
		ArrayList<Grade> resultFromDB = gradeRepo.findByStudentIds(id);
		if(resultFromDB.isEmpty()) {
			throw new Exception("studenta ar id "+id+" nav piesaistita neviena atzime");
		}
		return resultFromDB;
	}

	@Override
	public ArrayList<Grade> filterGradesByCourseTitle(String title) throws Exception {
		if(gradeRepo.count()==0) {
			throw new Exception("Atzimju tabula ir tuksa un nav iespejams filtret");
		}
		if(title==null||title.isEmpty()||!title.matches("[A-Z]{1}[A-Za-z0-9 ]{3,40}")) {
			throw new Exception("Kursa nosaukuma nav ievadits korekti");
		}
		if(!courseRepo.existsByTitle(title)) {
			throw new Exception("kurss ar nosaukumu " + title+ " neeksiste");
		}
		ArrayList<Grade> results = gradeRepo.findByCourseTitle(title);
		if(results.isEmpty()) {
			throw new Exception("Nav neviena atzime, kura ir piesaistita kursam");
		}
		return results;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorDegree(Degree degree) throws Exception {
		if(degree==null) {
			throw new Exception("Nevar atrasts, jo degree ir tukss");
		}
		if(courseRepo.count()==0) {
			throw new Exception("Tabula ir tuksa nav iespejams filtret");
		}
		if(profRepo.existsByDegree(degree)) {
			throw new Exception("profesori ar sadu "+degree+" neeksiste");
		}
		ArrayList<Course> results = courseRepo.findByProfessorDegree(degree);
		if(results.isEmpty()) {
			throw new Exception("Nav neviens kurs kurs butu piesaistits profesoram ar so gradu "+degree);
		}
		return results;
	}

	@Override
	public ArrayList<Student> filterStudentByBadGrades() throws Exception {
		if(gradeRepo.count()==0) {
			throw new Exception("Atzimju tabula ir tuksa un nav iespejams filtret");
		}
		if(studRepo.count()==0) {
			throw new Exception("Studentu tabula ir tuksa nevar filtret datus");
		}
		ArrayList<Student> results = studRepo.findByGradesGradeLessThan(4);
		if(results.isEmpty()) {
			throw new Exception("nav neviena studenta kuram butu nesekmiga atzime");
		}
		return results;
	}

}
