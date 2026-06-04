package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Degree;
import lv.venta.service.impl.FilterServiceImpl;

@Controller
@RequestMapping("/filter")
public class filterStudentController {
	@Autowired
	private FilterServiceImpl filterService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/filter/grades/student/1
	public String getControllerGradesByStudentId(@PathVariable(name="id")long id, Model model) {
		try {
			model.addAttribute("package", filterService.filterGradesByStudentId(id));
			return "show-multiple-grades";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/grades/course/{title}")//localhost:8080/filter/grades/course/Programmesana JAVA
	public String getControllerGradesByCourseTitle(@PathVariable(name="title")String title,Model model) {
		try {
			model.addAttribute("package", filterService.filterGradesByCourseTitle(title));
			return "show-multiple-grades";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/course/professor/{degree}")//localhost:8080/filter/course/professor/master
	public String getControllerCourseByProfessorDegree(@PathVariable(name="degree")Degree degree, Model model) {
		try {
			model.addAttribute("package", filterService.filterCoursesByProfessorDegree(degree));
			return "show-multiple-grades";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/students/failed")//localhost:8080/filter/students/failed
	public String getComtrollerFailedStudents(Model model) {
		try {
			model.addAttribute("package", filterService.filterStudentByBadGrades());
			return "show-multiple-students";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
	}

}
}
