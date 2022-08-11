package io.swagger.api;

import io.swagger.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class GetAllTasksApiControllerIntegrationTest {

    @Autowired
    private GetAllTasksApi api;

    @Test
    public void searchInventoryTest() throws Exception {
        String userName = "userName_example";
        ResponseEntity<List<Task>> responseEntity = api.searchInventory(userName);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
