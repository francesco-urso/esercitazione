package org.example;

import org.example.usermanagement.InvalidUserException;
import org.example.usermanagement.Logger;
import org.example.usermanagement.Role;
import org.example.usermanagement.User;
import org.example.usermanagement.UserService;

import java.util.*;

import static org.example.usermanagement.UserService.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        List<User> users = new ArrayList<>(UserService.getAllUser());

        System.out.println("Utente");
        Optional<User> maybeUser = findUserById(3L);
        maybeUser.ifPresentOrElse(
                u -> System.out.println("Trovato: " + u.getUsername()),
                () -> System.out.println("Utente non trovato!")
        );

        System.out.println("Moderatori: ");
        UserService.getUserForRole(Role.MODERATOR);

        System.out.println("Ordine email: ");
        UserService.orderEmail(users);

        Set<User> uniqueUsers = new HashSet<>(users);
        logger.log("Utenti unici: " + uniqueUsers.size());

        // test errore su email user
        try{
            User e1 = new User(1L, "FakeUserError", "emailerror.com", Role.ADMIN);
            checkUser(e1);
        } catch (InvalidUserException e) {
            logger.log("Errore " + e.getMessage());
        }
    }

    public static void checkUser(User user) throws InvalidUserException {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new InvalidUserException("Email non valida per user:" + user.getUsername());
        }
    }
}