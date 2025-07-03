package org.example.usermanagement;

import java.util.Objects;

public class User {
    private Long id;
    private String username;
    private String email;
    private Role role;

    public User(Long id, String username, String email, Role role){
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    //Get Set
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    @Override
    public String toString() {
        return "User{id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( ! (o instanceof User user) ) return false;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
