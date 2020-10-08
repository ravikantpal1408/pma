package com.rkp.pma;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class ProjectManagementApplicationTests {

	// @BeforeTestClass
	// public void beforeClass() {
	// 	System.out.println("in before class");
	// }

	@Test
	void contextLoads() {
		String valueOne = "test";
		String valueTwo = "test";
		assertEquals(valueOne, valueTwo);
	}


}
