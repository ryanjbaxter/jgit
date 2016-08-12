package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@DirtiesContext
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
