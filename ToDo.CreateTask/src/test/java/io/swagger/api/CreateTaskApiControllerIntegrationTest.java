package io.swagger.api;

import io.swagger.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateTaskApiControllerIntegrationTest {

    @Autowired
    private CreateTaskApi api;

    @Test
    public void addTaskTest() throws Exception {
        Task body = new Task();
        ResponseEntity<Void> responseEntity = api.addTask(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
