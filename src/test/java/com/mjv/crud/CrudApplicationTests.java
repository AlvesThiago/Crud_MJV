package com.mjv.crud;

import com.mjv.crud.dto.CrudDTO;
import com.mjv.crud.model.Crud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrudApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateCrudSucess() {
		var crud = new CrudDTO("crud 1", "desc crud 1", false, 1);

		webTestClient
				.post()
				.uri("/cruds")
				.bodyValue(crud)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(crud.getName())
				.jsonPath("$[0].description").isEqualTo(crud.getDescription())
				.jsonPath("$[0].done").isEqualTo(crud.isDone())
				.jsonPath("$[0].priority").isEqualTo(crud.getPriority());

	}

	@Test
	void testCreateCrudFailure() {
		var crud = new CrudDTO("crud 1", "desc crud 1", false, 1);

		webTestClient
				.post()
				.uri("/cruds")
				.bodyValue(new Crud("", "", false, 0)).exchange()
				.expectStatus().isBadRequest();



	}

}
