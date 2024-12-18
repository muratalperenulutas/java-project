package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.models.User;
import org.project.data.JsonRepository;
import org.project.services.UserService;
import org.project.data.OsUtil;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private static JsonRepository<User> userRepository;
    private static UserService userService;
    private static final String testFileName = "test-users.json";
    private static String testFilePath;

    @BeforeAll
    public static void setup() {
        testFilePath = OsUtil.getUserDataPath(testFileName);
        System.out.println(testFilePath);
    }

    @BeforeEach
    public void init() {
        OsUtil.createFileIfNotExists(testFilePath);
        userRepository = new JsonRepository<>(testFilePath, User[].class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testAddUser() {
        User newUser = new User("john@example.com", "password123");

        userService.addUser(newUser);

        List<User> users = userRepository.findAll();
        assertEquals(1, users.size(), "There should be one user.");
        assertEquals(newUser.getEmail(), users.get(0).getEmail(), "The added user's email should match.");
    }

    @Test
    public void testAddDuplicateUser() {
        User user1 = new User("john@example.com", "password123");
        User user2 = new User( "john@example.com", "password456");

        userService.addUser(user1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(user2);
        });

        assertEquals("User already exists", exception.getMessage());
    }

    @Test
    public void testAuthenticateUser() {
        User user = new User( "john@example.com", "password123");

        userService.addUser(user);

        User authenticatedUser = userService.authenticate("john@example.com", "password123");

        assertNotNull(authenticatedUser, "Authentication should be successful.");
        assertEquals(user.getEmail(), authenticatedUser.getEmail(), "Authenticated user's email should match.");
    }

    @Test
    public void testAuthenticateUser_Failure() {
        User user = new User("john@example.com", "password123");

        userService.addUser(user);

        User authenticatedUser = userService.authenticate("john@example.com", "wrongpassword");

        assertNull(authenticatedUser, "Authentication should fail with incorrect password.");
    }

    @Test
    public void testGetUserByEmail_Found() {
        User user = new User("john@example.com", "password123");

        userService.addUser(user);

        User retrievedUser = userService.getUserByEmail("john@example.com");

        assertNotNull(retrievedUser, "User should be found.");
        assertEquals(user.getEmail(), retrievedUser.getEmail(), "Retrieved user's email should match.");
    }

    @Test
    public void testGetUserByEmail_NotFound() {
        User retrievedUser = userService.getUserByEmail("nonexistent@example.com");

        assertNull(retrievedUser, "No user should be found with this email.");
    }

    @AfterEach
    public void cleanup() {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
