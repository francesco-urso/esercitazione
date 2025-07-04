package org.example.usermanagement;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    static List<User> users = List.of(
        new User(1L, "Mario", "mario@email.com", Role.USER),
        new User(2L, "Giulia", "giulia@email.com", Role.ADMIN),
        new User(3L, "Edoardo", "edoardo@email.com", Role.USER),
        new User(4L, "Carmelo", "carmelo@email.com", Role.USER),
        new User(5L, "Giovanni", "giovanni@email.com", Role.MODERATOR),
        new User(6L, "Mattia", "mattia@email.com", Role.MODERATOR),
        new UserBuilder()
                .setId(7L)
                .setUsername("Elena")
                .setEmail("elena@email.com")
                .setRole(Role.USER)
                .build()
    );

    public static List<User> getAllUser() {
        return new ArrayList<>(users);
    }
    public static Optional<User> findUserById(long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

    }

    public static void getUserForRole(Role role) {
        List<User> filterUsers = users.stream()
                .filter(u -> u.getRole().equals(role))
                .sorted(Comparator.comparing(User::getUsername))
                .toList();
        if (filterUsers.isEmpty()) {
            System.out.println("User non trovato");
        } else {
            filterUsers.stream()
                    .map(User::getUsername)
                    .forEach(System.out::println);
        }
    }

    public static void orderEmail(List<User> users) {
        List<User> sortedUser = users.stream()
                .sorted(Comparator.comparing(User::getEmail))
                .toList();
        if (sortedUser.isEmpty()) {
            System.out.println("User non trovato");
        } else {
            sortedUser.forEach(System.out::println);
        }
    }
}
