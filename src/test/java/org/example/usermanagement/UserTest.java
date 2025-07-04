package org.example.usermanagement;

import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserEquality(){
        User u1 = new User(1L, "Katia", "katia@email.com", Role.USER);
        User u2 = new User(1L, "Katia", "katia@email.com", Role.USER);

        assertEquals(u1, u2);
    }

    @Test
    public void testInvalidUserException(){
        User u = new User(3L, "Test", "invalidEmail",  Role.USER);
        
        Exception e = assertThrows(InvalidUserException.class, ()->{
            Main.checkUser(u);
        });
        assertTrue(e.getMessage().contains("Email non valida"));
    }
}
