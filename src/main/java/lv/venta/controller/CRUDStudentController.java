package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Student;
import lv.venta.service.ICRUDStudentService;

@Controller
@RequestMapping("/student/crud")
public class CRUDStudentController {
	@Autowired
	private ICRUDStudentService studService;
	
	@GetMapping("/all")//localhost:8080/student/crud/all
	public String getControllerAllStudents(Model model) {
		try{
		model.addAttribute("package", studService.retrieveAll());
		return "show-multiple-students";
	}catch(Exception e) {
		model.addAttribute("package", e.getMessage());
		return "error-page";
	}
	}
	@GetMapping("/delete/{id}")//localhost:8080/student/crud/delete/
	public String getControllerdeleteById(@PathVariable(name= "id") long id,Model model) {
		try {
			studService.deleteById(id);
			model.addAttribute("package", studService.retrieveAll());
			return "show-multiple-students";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
}
