package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginLogicTest {

    boolean isValidLogin(String user, String pass) {
        return user.equals("admin") && pass.equals("password123");
    }

    @Test
    void validLoginShouldPass() {
        assertTrue(isValidLogin("admin", "password123"));
    }

    @Test
    void invalidLoginShouldFail() {
        assertFalse(isValidLogin("admin", "wrong"));
    }

    @Test
    void emptyCredentialsFail() {
        assertFalse(isValidLogin("", ""));
    }
}
