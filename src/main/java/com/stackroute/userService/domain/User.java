package com.stackroute.userService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
int idea;
String firstName;
String lastName;
int age;

public User(){
};

    public User(int id, String firstName, String lastName, int age) {
        this.idea = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getIdea()
    {
        return idea;
    }

    public void setIdea(int idea) {
        this.idea = idea;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + idea +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
