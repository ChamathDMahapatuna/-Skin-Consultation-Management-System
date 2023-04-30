package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
public class Check_Doc extends JFrame {
    static JComboBox doc_Names;
    private JButton searchBut;
    static JComboBox date;
    static JComboBox year;
    static JComboBox start_Time;
    static JComboBox end_Time;
    static JComboBox month;
    private JLabel label_Start_Time;
    private JLabel label_End_Time;
    private JLabel label_Date;
    private JLabel label_Doc;
    private JLabel labe_lMon;
    private JLabel label_Year;
    private JLabel Error_Message;
    private JButton back;
    private JButton book2;

    ArrayList<Consultation> Consultation_info = Consultation.Consultation_Info;
    ArrayList<Doctor> doctors =  WestminsterSkinConsultationManager.Doctor_info;;
    ArrayList<String> availableDoctors = new ArrayList<>();

    String[] dateItems = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] monthItems = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] yearItems = {"2023", "2022"};
    String[] startTimeItems = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
    String[] endTimeItems = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
    String[] doctorsNames = {};

    public Check_Doc(){

        this.setTitle("Add Consultation");
        this.setSize(1000, 420);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.red);


        ArrayList<String> docDetails1 = new ArrayList<String>();
        for (int i = 0; i < doctors.size(); i++) {
            String doctor1 = doctors.get(i).getSurname();
            String doctor2 = doctors.get(i).getName();
            docDetails1.add(doctor2+" "+doctor1);}
            doctorsNames = docDetails1.toArray(doctorsNames);


        Error_Message = new JLabel ("");
        doc_Names = new JComboBox(doctorsNames);
        searchBut = new JButton("Search");
        date = new JComboBox(dateItems);
        year = new JComboBox(yearItems);
        start_Time = new JComboBox(startTimeItems);
        end_Time = new JComboBox(endTimeItems);
        month = new JComboBox(monthItems);
        label_End_Time = new JLabel("End Time:");
        label_Start_Time = new JLabel("Start Time:");
        label_Date = new JLabel("Day:");
        label_Doc = new JLabel("Doctor:");
        labe_lMon = new JLabel("Month:");
        label_Year = new JLabel("Year:");
        back = new JButton("Back");
        book2 = new JButton("Book");

        //add components
        add(doc_Names);
        add(searchBut);
        add(date);
        add(year);
        add(start_Time);
        add(end_Time);
        add(month);
        add(label_Start_Time);
        add(label_End_Time);
        add(Error_Message);
        add(label_Date);
        add(label_Doc);
        add(labe_lMon);
        add(label_Year);
        add (back);
        add (book2);


        //set component bounds (only needed by Absolute Positioning)
        doc_Names.setBounds(280, 100, 100, 25);
        searchBut.setBounds(130, 260, 100, 25);
        date.setBounds(280, 150, 100, 25);
        year.setBounds(680, 150, 100, 25);
        start_Time.setBounds(280, 200, 100, 25);
        end_Time.setBounds(493, 200, 100, 25);
        month.setBounds(493, 150, 100, 25);
        label_Start_Time.setBounds(130, 200, 65, 25);
        label_End_Time.setBounds(400, 200, 65, 25);
        label_Date.setBounds(130, 150, 50, 25);
        label_Doc.setBounds(130, 100, 50, 25);
        labe_lMon.setBounds(400, 150, 50, 25);
        label_Year.setBounds(600, 150, 50, 25);
        back.setBounds(300, 260, 100, 25);
        book2.setBounds(470, 260, 100, 25);
        Error_Message.setBounds(130, 300, 800, 60);

        ActionHandler actionHandler = new ActionHandler();
        searchBut.addActionListener(actionHandler);
        back.addActionListener(actionHandler);
        book2.addActionListener(actionHandler);

    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() ==  searchBut) {
                if(Consultation_info.isEmpty()){
                    for (int i = 0; i < doctorsNames.length; i++){
                        if (doc_Names.getSelectedItem().equals(doctorsNames[i]) ) {
                            Consultation_GUI.doctor = (String) doc_Names.getSelectedItem();
                            Consultation_GUI addPatient = new Consultation_GUI ();
                            dispose();
                        }
                    }
                }else {
                    for (Consultation check : Consultation_info){
                        if(check.getDoctor().equals(doc_Names.getSelectedItem())){
                            if (((check.getEnd_time().getHour() < LocalTime.parse((CharSequence) end_Time.getSelectedItem()).getHour()) && (check.getEnd_time().getHour() < LocalTime.parse((CharSequence) start_Time.getSelectedItem()).getHour())) || ((check.getStart_time().getHour() > LocalTime.parse((CharSequence) end_Time.getSelectedItem()).getHour()) && (check.getStart_time().getHour() > LocalTime.parse((CharSequence) start_Time.getSelectedItem()).getHour()))) {
                                Consultation_GUI.doctor = (String) doc_Names.getSelectedItem();
                                Consultation_GUI addPatient = new Consultation_GUI();
                                dispose();
                                break;
                            }
                                else{
                                Error_Message.setText("Unfortunately the the Selected Doctorate iS not available Right now" +
                                        "\n If you need to continue with a random doctor Press book Button");
                                }

                        }

                    }
                }
            }

            if (e.getSource() == back) {
                GUI GUI = new GUI();
                dispose();
            }
            if (e.getSource() == book2) {
                    for (String doctor : doctorsNames) {
                        for (Consultation check : Consultation_info) {
                            if (!doctor.contains(check.getDoctor())) {
                                availableDoctors.add(doctor);
                            }
                        }
                    }
                    for (Consultation check : Consultation_info) {
                        if (((check.getEnd_time().getHour() < LocalTime.parse((CharSequence) end_Time.getSelectedItem()).getHour()) && (check.getEnd_time().getHour() < LocalTime.parse((CharSequence) start_Time.getSelectedItem()).getHour())) || ((check.getStart_time().getHour() > LocalTime.parse((CharSequence) end_Time.getSelectedItem()).getHour()) && (check.getStart_time().getHour() > LocalTime.parse((CharSequence) start_Time.getSelectedItem()).getHour()))) {
                            availableDoctors.add(check.getDoctor());
                        }
                    }
                    Random rand = new Random();
                    int randInt = rand.nextInt(availableDoctors.size() + 1);
                    Consultation_GUI.doctor = availableDoctors.get(rand.nextInt(availableDoctors.size()));
                    Consultation_GUI.count = false;
                    Consultation_GUI addPatient = new Consultation_GUI();
                    dispose();
                }
            }
        }
    }




