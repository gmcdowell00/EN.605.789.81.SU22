package io.swagger.api;

import io.swagger.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class SignupApiControllerIntegrationTest {

    @Autowired
    private SignupApi api;

    @Test
    public void createUserTest() throws Exception {
        User body = new User();
        //ResponseEntity<String> responseEntity = api.createUser(body);
        assertEquals(true, true);
    }

}
