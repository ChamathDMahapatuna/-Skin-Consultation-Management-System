package com.company;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation extends WestminsterSkinConsultationManager {

    static ArrayList<Consultation> Consultation_Info = new ArrayList<Consultation>();         //creating array list called Doctor_info
    private LocalTime Start_time;
    private LocalTime End_time;
    private LocalDate date;
    private int cost;
    private String notes;
    private String patient;
    private String doctor;

    public Consultation(LocalDate consultationDate, LocalTime startTime, LocalTime endTime, int cost, String notes, String doctor, String fullName) {
        this.date = consultationDate;
        this.Start_time = startTime;
        this.End_time = endTime;
        this.cost = cost;
        this.notes = notes;
        this.doctor = doctor;
        this.patient = fullName;

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart_time() {
        return Start_time;
    }

    public void setStart_time(LocalTime start_time) {
        Start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return End_time;
    }

    public void setEnd_time(LocalTime end_time) {
        End_time = end_time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }








}
