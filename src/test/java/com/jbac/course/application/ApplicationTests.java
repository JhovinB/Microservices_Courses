package com.jbac.course.application;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	
	@Autowired
	MockMvc mock;
	
	@Test
	@Order(0)
	void deleteCourse() throws Exception {
		mock.perform(delete("/courses/Python"));
	}
	@Test
	@Order(1)
	void testCourses() throws Exception {
		mock.perform(get("/courses")).andDo(print());
	}
	
	@Test
	@Order(2)
	void saveCourse() throws Exception {
		mock.perform(post("/courses")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"name\":\"Angular 10\",\"duration\":40,\"hours\":\"tarde\"}"))
					.andDo(print());
	}
	@Test
	@Order(3)
	void updateCourse() throws Exception {
		mock.perform(put("/courses")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"name\":\"Angular 10\",\"duration\":80,\"hours\":\"temprano\"}"))
					.andDo(print());
	}

}
