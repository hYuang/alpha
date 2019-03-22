package com.huang.alpha.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectInfoControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new ProjectInfoController()).build();
	}

	@Test
	public void testProjectInfo() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/info/porject").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

}
