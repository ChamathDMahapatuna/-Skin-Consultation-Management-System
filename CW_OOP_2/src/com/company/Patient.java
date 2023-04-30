package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person {
    private String patient_ID;
    static ArrayList<Patient> patient_Info = new ArrayList<Patient>();         //creating array list called Doctor_info
    public Patient(String name, String surname, LocalDate dateOfBirth, int mobileNumber, String patientId){
        this.setName(name);
        this.setSurname(surname);
        this.setDate_of_birth(dateOfBirth);
        this.setMobile_number(mobileNumber);
        this.patient_ID = patientId;

    }

    public Patient() {

    }

    public String getPatient_ID() {

        return patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }



}
