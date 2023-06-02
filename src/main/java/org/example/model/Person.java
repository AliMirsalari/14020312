package org.example.model;

import lombok.*;

import java.util.Date;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class Person {
    private String natCode;
    private String firstName;
    private String lastName;

}
