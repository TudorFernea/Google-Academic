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
	CommandLineRunner run(SecurityService securityService, UserService userService, StudentService studentService, TeacherService teacherService, YearOfStudyService yearOfStudyService, SpecializationService specializationService, DisciplineService disciplineService, CurriculumService curriculumService){
		return args -> {
			//User user =  new User("user1","1234","test@gmail.com","ion","pop");
			//userService.addUser(user);

			Student student = new Student("user1","1234","test@gmail.com","ion","pop", "923");
			studentService.addStudent(student);
			securityService.addUser(student);

			Specialization specialization = new Specialization("mate info","engleza");
			specializationService.addSpecialization(specialization);

			YearOfStudy yearOfStudy = new YearOfStudy(1, specialization);
			yearOfStudyService.addYearOfStudy(yearOfStudy);

			YearOfStudy yearOfStudy2 = new YearOfStudy(2, specialization);
			yearOfStudyService.addYearOfStudy(yearOfStudy2);


			Discipline discipline = new Discipline("asc",false);
			discipline.setYearOfStudy(yearOfStudy);
			disciplineService.addDiscipline(discipline);

			Curriculum curriculum = new Curriculum("un prost", discipline);
			discipline.setCurriculum(curriculum);
			curriculumService.addCurriculum(curriculum);
			disciplineService.addDiscipline(discipline);


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
