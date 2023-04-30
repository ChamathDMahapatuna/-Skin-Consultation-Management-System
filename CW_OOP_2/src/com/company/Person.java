package com.company;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;
    private String surname;
    private LocalDate Date_of_birth;
    private int mobile_number;

    public String getName() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return null;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDate_of_birth() {return Date_of_birth;}

    public void setDate_of_birth(LocalDate Date_of_birth) {
        this.Date_of_birth = Date_of_birth;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }


    public static void main(String[] args) {


    }
}
