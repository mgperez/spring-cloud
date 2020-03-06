package com.garpesa.cloudgatewayservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
class CloudGatewayServiceApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void contextLoads() {
	}

	@Test
	void testFirstMicroservice() {

		webClient
				.get().uri("/employees/message")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.headers.Hello").isEqualTo("World");

	}

}
