package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.repo.GradeRepo;
import lv.venta.repo.StudentRepo;
import lv.venta.service.ICRUDfilterservice;

public class FilterServiceImpl implements ICRUDfilterservice{
	@Autowired
	private StudentRepo studRepo;
	private GradeRepo gradeRepo;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorDegree(Degree degree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
