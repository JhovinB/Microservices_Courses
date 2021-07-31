package com.jbac.course.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbac.course.model.Course;

@RestController
public class CoursesRestController {
	
	
	private List<Course> courses;
	
	@PostConstruct // Despues que se instancia el controlador
	//este se ejecuta
	public void init() {
		
		courses = new ArrayList<>();
		courses.add(new Course("Spring",25,"tarde"));
		courses.add(new Course("Python",25,"temprano"));
		courses.add(new Course("Go",25,"tarde"));
		courses.add(new Course("Spring Boot",25,"tarde"));
		courses.add(new Course("C#",25,"temprano"));
		
	}

	
	@GetMapping("/courses")
	public List<Course> findAllCourse(){
		return courses;
	}
	//Encontrar cursos por nombre
	@GetMapping("/courses/{name}")
	public  List<Course> searchCourse(@PathVariable("name") String name) {
		List<Course> course = new ArrayList<>();
		for (Course c : courses) {
			if(c.getName().contains(name)) {
				course.add(c);
			}
		}
		return course;
	}
	
	@PostMapping("/courses")
	public List<Course> saveCourse(@RequestBody Course course){
		courses.add(course);
		return courses;
	}
	@PutMapping("/courses")
	public List<Course> updateCourse(@RequestBody Course course){
		for (int i = 0; i < courses.size(); i++) {
			if(courses.get(i).getName().equals(course.getName())) {
				courses.set(i, course);
			}
		}
		return courses;
	}
	
	@DeleteMapping("/courses/{name}")
	public void deleteCourse(@PathVariable("name") String name) {
		courses.removeIf(c->c.getName().equals(name));
	}
	
	
	@GetMapping("/course")
	public Course Curse() {
		return new Course("Java",100,"temprano");
	}
//	@GetMapping(value="course",produces=MediaType.APPLICATION_JSON_VALUE)
//	public Course getCurse() {
//		return new Course("Java",100,"temprano");
//	}
}
