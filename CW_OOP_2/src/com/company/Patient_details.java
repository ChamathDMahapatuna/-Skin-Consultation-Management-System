package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Patient_details extends JFrame implements ActionListener {

    static JButton component1;
    static JLabel lbl;
    static ArrayList<Patient> d1 = Patient.patient_Info;
    JTable Patienttable;
    Patient_details()
    {
        prepareGUI();
    }

    public void prepareGUI() {
        this.setTitle("View Patient Details");
        Color ivory = new Color(255, 255, 208);
        this.setVisible(true);
        this.setSize(1500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        String[] tableColumns = {"Patient_ID","First Name", "SurName", "DOB", "Mobile No"};
        Object[][] data = new Object[d1.size()][6];

        int index = 0;
        for (Patient doctor : d1) {
            data[index][0] = doctor.getPatient_ID();
            data[index][1] = doctor.getName();
            data[index][2] = doctor.getSurname();
            data[index][3] = doctor.getDate_of_birth();
            data[index][4] = doctor.getMobile_number();
            index++;
        }
        component1();
        DefaultTableModel tableModel = new DefaultTableModel(data, tableColumns);
        JTable doctorTable = new JTable(tableModel);
        doctorTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        doctorTable.setAutoCreateRowSorter(true);
        add(scrollPane);
    }
    public void component1(){
        component1 = new JButton("Back");
        component1.addActionListener(this);
        component1.setBounds (645, 290, 200, 32);
        add (component1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == component1){
            GUI GUI = new GUI();
            dispose();
        }
    }
}

