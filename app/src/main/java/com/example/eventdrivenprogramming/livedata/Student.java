package com.example.eventdrivenprogramming.livedata;

public class Student {
    String firstName;
    String lastName;
    String addmissionNumber;

    public Student(String firstName, String lastName, String addmissionNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addmissionNumber = addmissionNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddmissionNumber() {
        return addmissionNumber;
    }

    public void setAddmissionNumber(String addmissionNumber) {
        this.addmissionNumber = addmissionNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", addmissionNumber='" + addmissionNumber + '\'' +
                '}';
    }
}
