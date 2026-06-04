package lv.venta;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professors;
import lv.venta.model.Student;
import lv.venta.repo.CourseRepo;
import lv.venta.repo.GradeRepo;
import lv.venta.repo.ProfessorRepo;
import lv.venta.repo.StudentRepo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgIzSeminar2Spring1Application {

	private final GradeRepo gradeRepo;
	private final CourseRepo courseRepo;
	private final ProfessorRepo professorRepo;
	private final StudentRepo studentRepo;
	ProgIzSeminar2Spring1Application(StudentRepo studentRepo, ProfessorRepo professorRepo, CourseRepo courseRepo, GradeRepo gradeRepo) {
		this.studentRepo = studentRepo;
		this.professorRepo = professorRepo;
		this.courseRepo = courseRepo;
		this.gradeRepo = gradeRepo;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProgIzSeminar2Spring1Application.class, args);
	}
	@Bean
	public CommandLineRunner saveDataInDB(StudentRepo studRepo, ProfessorRepo profRepo,
			CourseRepo courseRepo, GradeRepo graderepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professors p1 = new Professors("Karlis", "Immers", Degree.master);
				Professors p2 = new Professors("Karina","Skirmante", Degree.master);
				profRepo.saveAll(Arrays.asList(p1,p2));
				Student s1 = new Student("Mikus Valts","Sarovs");
				Student s2 = new Student("Kristers","Dogudovs");
				studRepo.saveAll(Arrays.asList(s1,s2));
				Course c1 = new Course("Programmesana JAVA", 4, p2);
				Course c2 = new Course("Timekla tehnologijas", 6 ,p1);
				courseRepo.saveAll(Arrays.asList(c1,c2));
				Grade g1 = new Grade(8,s1,c1);
				Grade g2 = new Grade(6,s1,c2);
				Grade g3 = new Grade(10,s2,c1);
				Grade g4 = new Grade(1,s2,c2);
				graderepo.saveAll(Arrays.asList(g1,g2,g3,g4));
				
			}
		};
	}
}
