package com.nextconnect.NextConnect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nextconnect.dto.UserFeedDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = NextConnectApplication.class)
//@Import(NextConnectTestConfig.class)
class NextConnectApplicationTests {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@LocalServerPort
	private int serverPort;

	@Test
	void contextLoads() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("user1", "user1Pass");
		
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		
		ResponseEntity<String> resp=testRestTemplate.exchange("http://localhost:"+serverPort+""
				+ "/get-user-details?userMailId=tadiboyinaavinash@gmail.com", HttpMethod.GET, entity, String.class);
		
		System.out.println(resp.getBody());
		Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode());
	}
	
	

}
