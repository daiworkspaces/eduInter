package com.example.eduInter;

import com.example.ThreeTest.ThreeGet;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class EduInterApplicationTests {
	MockMvc mvc;
	@Before
	public void before()
	{
		mvc = MockMvcBuilders.standaloneSetup(new ThreeGet()).build();
	}
	@Test
	public void test1() throws Exception {
		RequestBuilder req = get("/ThreeGetMethod");
		mvc.perform(req).andExpect(status().isOk());
	}

	@Test
	void contextLoads() {
	}

}
