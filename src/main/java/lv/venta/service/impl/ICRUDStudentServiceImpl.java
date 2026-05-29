package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.GradeRepo;
import lv.venta.repo.StudentRepo;
import lv.venta.service.ICRUDStudentService;

@Service
public class ICRUDStudentServiceImpl implements ICRUDStudentService {

	@Autowired
	private StudentRepo studRepo;
	@Autowired
	private GradeRepo gradeRepo;
	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula ir tukša");
		}
		return (ArrayList<Student>) studRepo.findAll();
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		if(studRepo.count()==0) {
			throw new Exception("Nevar atrast ja tabula ir tuksa");
		}
		if(id<1) {
			throw new Exception("Id nevar but negativs");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Students ar id "+id+" neeksiste");
		}
		
		return studRepo.findById(id).get();
	}

	@Override
	public void deleteById(long id) throws Exception {
		Student studentsForDelete = retrieveById(id);
		ArrayList<Grade> allGradesForStudent= gradeRepo.findByStudentIds(id);
		for(Grade tempG: allGradesForStudent) {
			tempG.setStudent(null);
			gradeRepo.save(tempG);
		}
		studRepo.delete(studentsForDelete);
	}

	@Override
	public void create(Student newObject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(long id, String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
