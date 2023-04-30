package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Consultation_GUI extends JFrame {

    ArrayList<Consultation> Consultation_info = Consultation.Consultation_Info;

    private JButton back;
    private JButton add;
    private JLabel addDet;
    private JLabel name;
    private JLabel surname;
    private JLabel dob;
    private JLabel mobNum;
    private JLabel id;
    private JLabel notes;
    private JLabel dateFormat;
    private JLabel note1;
    private JLabel note2;
    private JTextField name1;
    private JTextField surname1;
    private JTextField dob1;
    private JTextField mobNum1;
    private JTextField id1;
    private JTextField notes1;
    private JLabel note;
   static boolean count;
    static LocalDate date;
    static LocalTime startTime;
    static LocalTime endTime;
    static String doctor;

    public Consultation_GUI()
    {

        setTitle("Add Patient");
        setSize(626, 750);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //construct components
        back = new JButton ("Back");
        add = new JButton ("Add");
        addDet = new JLabel ("Fill the patient's details here.");
        name = new JLabel ("Name:");
        surname = new JLabel ("Surname:");
        dob = new JLabel ("Date of Birth:");
        mobNum = new JLabel ("Mobile Number:");
        id = new JLabel ("ID:");
        notes = new JLabel ("Notes:");
        dateFormat = new JLabel ("YYYY-MM-DD");
        note1 = new JLabel ("The first consultation is £15 per hour.");
        note2 = new JLabel ("Any other consultations are £25 per hour for each.");
        name1 = new JTextField (5);
        surname1 = new JTextField (5);
        dob1 = new JTextField (5);
        mobNum1 = new JTextField (5);
        id1 = new JTextField (5);
        notes1 = new JTextField (5);
        note = new JLabel("Note!");

        //add components
        add (back);
        add (add);
        add (addDet);
        add (name);
        add (surname);
        add (dob);
        add (mobNum);
        add (id);
        add (notes);
        add (dateFormat);
        add (note1);
        add (note2);
        add (name1);
        add (surname1);
        add (dob1);
        add (mobNum1);
        add (id1);
        add (notes1);
        add (note);


        //set component bounds (only needed by Absolute Positioning)
        back.setBounds (275, 665, 100, 20);
        add.setBounds (160, 665, 100, 20);
        addDet.setBounds (20, 25, 300, 25);
        name.setBounds (40, 90, 100, 25);
        surname.setBounds (40, 145, 100, 25);
        dob.setBounds (40, 200, 100, 25);
        mobNum.setBounds (40, 255, 100, 25);
        id.setBounds (40, 315, 100, 25);
        notes.setBounds (40, 375, 100, 25);
        dateFormat.setBounds (390, 200, 100, 25);
        note1.setBounds (40, 555, 350, 25);
        note2.setBounds (40, 600, 400, 25);
        name1.setBounds (160, 90, 200, 25);
        surname1.setBounds (160, 145, 200, 25);
        dob1.setBounds (160, 200, 200, 25);
        mobNum1.setBounds (160, 255, 200, 25);
        id1.setBounds (160, 315, 200, 25);
        notes1.setBounds (160, 375, 200, 25);
        note.setBounds (20, 520, 100, 25);
        ActionHandler actHand = new ActionHandler();
        back.addActionListener(actHand);
        add.addActionListener(actHand);
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == back){
                Check_Doc  Check_Doc = new  Check_Doc();
                dispose();
            }

            if(e.getSource() == add){

                if (name1.getText().equals("") || surname1.getText().equals("") || mobNum1.getText().equals("") || id1.getText().equals("") || notes.getText().equals("") || dob.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields!", "Fill the blanks", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    ArrayList<Patient> patients = Patient.patient_Info;

                    String name = name1.getText();
                    String surname = surname1.getText();
                    int mobNum = Integer.parseInt(mobNum1.getText());
                    String id = id1.getText();
                    String notes = name1.getText();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                    String day = (String) Check_Doc.date.getSelectedItem();
                    String month = (String) Check_Doc.month.getSelectedItem();
                    String year = (String) Check_Doc.year.getSelectedItem();
                    String date1 = day + "-" + month + "-" + year;
                    LocalDate date = LocalDate.parse(date1, formatter);
                    LocalTime startTime = LocalTime.parse((CharSequence) Check_Doc.start_Time.getSelectedItem());
                    LocalTime endTime = LocalTime.parse((CharSequence) Check_Doc.end_Time.getSelectedItem());

                    if (count) {
                        String doctor = (String) Check_Doc.doc_Names.getSelectedItem();
                    }


                    int cost = costCalculator(LocalTime.parse((CharSequence)Check_Doc.end_Time.getSelectedItem()).getHour() - LocalTime.parse((CharSequence)Check_Doc.start_Time.getSelectedItem()).getHour(), id);
                    JOptionPane.showMessageDialog(null, "Consultation Cost is : " + cost + ".00", "Consultation Cost", JOptionPane.INFORMATION_MESSAGE);

                    Patient patient = new Patient();
                    patient.setName(name);
                    patient.setSurname(surname);
                    patient.setMobile_number(mobNum);
                    patient.setDate_of_birth(date);
                    patient.setPatient_ID(id);
                    patients.add(patient);
                    String patientName1 = patient.getName();
                    String patientName2 = patient.getSurname();
                    String patientName = patientName1 + " " + patientName2;

                    Consultation consultation = new Consultation(date, startTime, endTime, cost, notes, doctor, patientName);
                    Consultation_info.add(consultation);  count = true;
                    JOptionPane.showMessageDialog(null, "Successfully added the consultation!", "Consultation is added", JOptionPane.INFORMATION_MESSAGE);

                }
                GUI GUI = new GUI();
                dispose();
            }
        }
    }

    public int costCalculator(int timePeriod, String patientID) {
        int cost = 0;
        for (Patient patient : Patient.patient_Info) {
            if (patient.getPatient_ID().equalsIgnoreCase(patientID)) {
                cost = timePeriod * 25;
                return cost;
            }
        }
        cost = timePeriod * 15;
        return cost;
    }

}