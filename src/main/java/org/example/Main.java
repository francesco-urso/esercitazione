package org.example;

import org.example.usermanagement.InvalidUserException;
import org.example.usermanagement.Logger;
import org.example.usermanagement.Role;
import org.example.usermanagement.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        User u1 = new User(1L, "Mario", "mario@email.com", Role.USER);
        User u2 = new User(2L, "Giulia", "giulia@email.com", Role.ADMIN);
        User u3 = new User(1L, "Mario", "mario@email.com", Role.USER);
        User u4 = new User(1L, "Mario", "marioemail.com", Role.USER);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Set<User> uniqueUsers = new HashSet<>(users);
        logger.log("Utenti unici: " + uniqueUsers.size());

        try{
            checkUser(u1);
        } catch (InvalidUserException e) {
            logger.log("Errore" + e.getMessage());
        }
    }

    public static void checkUser(User user) throws InvalidUserException {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new InvalidUserException("Email non valida per user:" + user.getUsername());
        }
    }
}