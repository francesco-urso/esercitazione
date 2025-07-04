package org.example.usermanagement;
//Pattern Builder, nel caso in cui alcuni campi siano opzionali
//utile su costruttori lunghissimi
public class UserBuilder {
    private Long id;
    private String username;
    private String email;
    private Role role;

    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        return new User(id, username, email, role);
    }
}
