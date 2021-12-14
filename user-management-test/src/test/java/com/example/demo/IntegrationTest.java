package com.example.demo;

import com.example.demo.model.dto.UserDto;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserManagementTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  @Title("Verify api create user")
  public void createUserTest() {
    headers.add("Content-Type", "application/json");
    HttpEntity<String> entity = new HttpEntity<String>("{ \"full_name\": \"Nguyen Van A\", \"email\": \"\", \"password\": \"abc123\", \"phone\": \"0942362001\" }", headers);
    ResponseEntity<UserDto> response = restTemplate.exchange(createURLWithPort("/users"), HttpMethod.POST, entity, UserDto.class);

    assertEquals(response.getStatusCode(), is(400));
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

}


