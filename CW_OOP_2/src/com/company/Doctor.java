package com.company;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Person implements Serializable {
    private String licence_number;
    private String specialisation;

    public Doctor(String fname, String licence_number, String surname, String specialization, LocalDate dob, int mobile_number) {
        this.setName(fname);
        this.setSurname(surname);
        this.setDate_of_birth(dob);
        this.setMobile_number(mobile_number);
        this.licence_number = licence_number;
        this.specialisation = specialization;
    }
    public Doctor() {
    }

    public String getLicence_number() {
        return licence_number;
    }
    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }
    public String getSpecialisation() {
        return specialisation;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }



}
