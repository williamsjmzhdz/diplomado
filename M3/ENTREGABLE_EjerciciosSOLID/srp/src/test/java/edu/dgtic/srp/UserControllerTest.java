package edu.dgtic.srp;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    //A valid USER JSON String
    private static final String VALID_USER_JSON = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";

    //Invalid USER JSON String - email format wrong
    private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";

    @Test
    public void mainTest() throws IOException {
        UserController controller = new UserController();
        //Check with valid JSON
        String response = controller.createUser(VALID_USER_JSON);
        assertEquals("SUCCESS", response, "Valid JSON received response");
        System.out.println("Valid JSON received response: "+response);
        //Check with invalid JSON
        response = controller.createUser(INVALID_USER_JSON);
        assertEquals("ERROR", response, "Invalid JSON received response");
        System.out.println("Invalid JSON received response: "+response);
    }
}