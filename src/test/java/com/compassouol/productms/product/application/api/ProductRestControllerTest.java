package com.compassouol.productms.product.application.api;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProductRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

		@Test
		void deveRetornar400CasoJsonInvalido() throws Exception {
			URI uri = new URI("/products");
			String json = "{\"name\": \"teste\", \"description\":\"teste\", \"price\":\"null\"}";
			
			mockMvc.perform(MockMvcRequestBuilders
					.post(uri)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers
					.status()
					.is(400));
		}
	

}
