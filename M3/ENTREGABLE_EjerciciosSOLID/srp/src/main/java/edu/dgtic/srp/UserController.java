package edu.dgtic.srp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//maven
import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {

    private Store store = new Store();
    private UserValidator userValidator;
    private UserPersistenceService userPersistenceService;

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        userValidator = new UserValidator();
        userPersistenceService = new UserPersistenceService();
        if(!userValidator.isValidUser(user)) {
            return "ERROR";
        }
        store.store(user);
        return "SUCCESS";
    }
}