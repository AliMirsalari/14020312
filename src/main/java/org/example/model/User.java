package org.example.model;

import lombok.*;

import java.security.PrivateKey;

@Getter
@Setter
@NoArgsConstructor

public class User extends Person{
    private String username;
    private String password;
    private String email;
    @Builder
    public User(String natCode, String firstName, String lastName, String username, String password, String email) {
        super(natCode, firstName, lastName);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", natCode='" + super.getNatCode() + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                '}';
    }
}
