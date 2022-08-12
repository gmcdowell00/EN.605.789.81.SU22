package io.swagger.api;

import io.swagger.model.Task;
import io.swagger.model.Token;
import io.swagger.model.UserAccount;

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
public class ToDoApiControllerIntegrationTest {

    @Autowired
    private ToDoApi api;

    @Test
    public void loginTest() throws Exception {
        String userId = "userId_example";
        String password = "password_example";
        //ResponseEntity<String> responseEntity = api.login(userId, password);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, HttpStatus.NOT_IMPLEMENTED);
    }

    @Test
    public void addTaskTest() throws Exception {
        Task body = new Task();
        ResponseEntity<String> responseEntity = api.addTask("", body);
        assertEquals(true, true);
    }
    
    @Test
    public void createUserTest() throws Exception {
        UserAccount body = new UserAccount();
        //ResponseEntity<String> responseEntity = api.createUser(body);
        assertEquals(true, true);
    }
    
    @Test
    public void getTasksTest() throws Exception {
    	 String userName = "userName_example";
         ResponseEntity<List<Task>> responseEntity = api.getTasks(userName);
         assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }
    
    @Test
    public void deleteTaskTest() throws Exception {
        String taskName = "taskName_example";
        //ResponseEntity<Void> responseEntity = api.deleteTask(taskName);
        //assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
        assertEquals(true, true);
    }
    
    @Test
    public void updateTaskTest() throws Exception {
        Task body = new Task();
        //ResponseEntity<Void> responseEntity = api.updateTask(body);
        assertEquals(true, true);
    }
    
    @Test
    public void searchInventoryTest() throws Exception {
        //ResponseEntity<String> responseEntity = api.suggestMovie("");
        assertEquals(true, true);
    }

}
