package com.example.demo;

import com.example.demo.DTOs.CurriculumDTO;
import com.example.demo.Models.*;
import com.example.demo.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AcademicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(SecurityService securityService, StudentService studentService, TeacherService teacherService, YearOfStudyService yearOfStudyService, SpecializationService specializationService, DisciplineService disciplineService, CurriculumService curriculumService, FacultyService facultyService){
		return args -> {
			//User user =  new User("user1","1234","test@gmail.com","ion","pop");
			//userService.addUser(user);

			Faculty faculty = new Faculty("matematica informatica");
			facultyService.addFaculty(faculty);

			Student student = new Student("user1","1234","test@gmail.com","ion","pop", "923");
			Student student2 = new Student("user4","1234","test@gmail.com","ana","pop", "923");
			studentService.addStudent(student2);
			studentService.addStudent(student);
			securityService.addUser(student);
			securityService.addUser(student2);

			Teacher teacher = new Teacher("user2","1234","test@gmail.com","abcd","pop", false);
			Teacher chief = new Teacher("user3","1234","test@gmail.com","mr","chief", true);
			teacher.setTeacherFaculty(faculty);
			chief.setTeacherFaculty(faculty);
			teacherService.addTeacher(teacher);
			teacherService.addTeacher(chief);
			securityService.addUser(teacher);
			securityService.addUser(chief);


			Specialization specialization = new Specialization("mate info","engleza");
			specialization.setSpecializationFaculty(faculty);
			specializationService.addSpecialization(specialization);

			YearOfStudy yearOfStudy = new YearOfStudy(1, specialization);
			yearOfStudyService.addYearOfStudy(yearOfStudy);

			YearOfStudy yearOfStudy2 = new YearOfStudy(2, specialization);
			yearOfStudyService.addYearOfStudy(yearOfStudy2);
			student.setYearOfStudy1(yearOfStudy);
			student2.setYearOfStudy1(yearOfStudy);
			studentService.addStudent(student);
			studentService.addStudent(student2);

			Discipline discipline = new Discipline("asc",false, 10);
			Discipline optional = new Discipline("fp",true, 2);

			discipline.setYearOfStudy(yearOfStudy);
			discipline.setTeacher(teacher);

			optional.setYearOfStudy(yearOfStudy);
			optional.setTeacher(teacher);

			disciplineService.addDiscipline(optional);
			disciplineService.addDiscipline(discipline);
			//teacherService.addTeacher(teacher);

			Curriculum curriculum = new Curriculum("un prost", discipline);
			Curriculum optionalCurriculum = new Curriculum("cel mai prost", optional);

			discipline.setCurriculum(curriculum);
			optional.setCurriculum(optionalCurriculum);

			curriculumService.addCurriculum(curriculum);
			curriculumService.addCurriculum(optionalCurriculum);

			disciplineService.addDiscipline(discipline);
			disciplineService.addDiscipline(optional);


			/*
			AcademicUser academicUser2 = new AcademicUser(null,"test.teacher","test","test.teacher@gmail.com","Test Teacher","5030303030303");
			service.saveAcademicUser(academicUser2);

			Teacher teacher = new Teacher(null, null, null);
			service.saveTeacher(teacher);

			service.assignUserToTeacher(academicUser2.getId(), teacher.getId());

			AcademicUser academicUser3 = new AcademicUser(null,"test.head","test","test.head@gmail.com","Test Head","5040404040404");
			service.saveAcademicUser(academicUser3);

			Teacher teacher1 = new Teacher(null, null, null);
			service.saveTeacher(teacher1);

			TeacherType teacherType = new TeacherType(null, "HEAD_OF_DEPARTMENT");
			service.saveTeacherType(teacherType);

			service.assignTeacherTypeToTeacher(teacherType.getId(),teacher1.getId());
			service.assignUserToTeacher(academicUser3.getId(), teacher1.getId());

			 */
		};
	}
}
