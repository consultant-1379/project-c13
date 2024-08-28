package com.ericsson.retrospective.tool;

import com.ericsson.retrospective.tool.controllers.ItemController;
import com.ericsson.retrospective.tool.service.RetrospectiveService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class RetrospectiveToolApplicationTests {

	@Autowired
	private ItemController controller;

	@Autowired
	private RetrospectiveService service;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}

}

