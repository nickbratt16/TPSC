package com.tpsc.thepeoplesscorecard.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "First Name is Required")
    @Size(min = 2, message = "First Name must be 2 or more characters")
    private String firstName;

    @NotBlank(message = "First Name is Required")
    @Size(min = 2, message = "First Name must be 2 or more characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email address")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Minimum age is 16")
    @Max(value = 110, message = "Maximum age is 110")
    private int age;

    private String favFighter;

    public User() {

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavFighter() {
        return favFighter;
    }

    public void setFavFighter(String favFighter) {
        this.favFighter = favFighter;
    }
}
