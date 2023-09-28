package com.qa.person.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class PersonDemoApplicationTests {

//	context -> where the beans go
	@Test
	void contextLoads() {
	}

}
