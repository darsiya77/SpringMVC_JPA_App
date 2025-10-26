package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @NotEmpty(message = "Name should not be empty")
   @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
   @Column(name = "name")
   private String firstName;

   @NotEmpty(message = "Name should not be empty")
   @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
   @Column(name = "last_name")
   private String lastName;

   @NotEmpty(message = "Email should not be empty")
   @Email(message = "Email should be valid")
   @Column(name = "email")
   private String email;


   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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


   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName = '" + firstName + '\'' +
              ", lastName = '" + lastName + '\'' +
              ", email = '" + email + '\'' +
              '}';
   }
}
