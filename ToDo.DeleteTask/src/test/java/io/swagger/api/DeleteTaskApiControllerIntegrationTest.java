package io.swagger.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class DeleteTaskApiControllerIntegrationTest {

    @Autowired
    private DeleteTaskApi api;

    @Test
    public void deleteTaskTest() throws Exception {
        String taskName = "taskName_example";
        //ResponseEntity<Void> responseEntity = api.deleteTask(taskName);
        //assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
