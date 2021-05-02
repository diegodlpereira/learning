package com.dlpereira.springaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

	@Autowired
	Service service;

	@Test
	public void testAspect() throws Exception {
		service.serve();
	}
}
