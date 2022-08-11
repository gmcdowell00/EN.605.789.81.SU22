package io.swagger.api;

import io.swagger.model.Token;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApiControllerIntegrationTest {

    @Autowired
    private LoginApi api;

    @Test
    public void loginTest() throws Exception {
        String userId = "userId_example";
        String password = "password_example";
        ResponseEntity<Token> responseEntity = api.login(userId, password);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
