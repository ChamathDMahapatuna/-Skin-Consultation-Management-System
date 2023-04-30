package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Consultation_Details_GUI extends JFrame implements ActionListener {

    static JButton component1;
    static ArrayList<Consultation> Consultation_info = Consultation.Consultation_Info;

    Consultation_Details_GUI() {
        prepareGUI();
    }
    public void prepareGUI() {
        this.setVisible(true);
        this.setSize(1500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        String[] tableColumns ={"Patient Name", "Doctor Name", "Consultation Date", "Consultation Start Time", "Consultation End Time", "Notes", "Cost"};
        Object[][] data = new Object[Consultation_info.size()][10];
        int index = 0;
        for (Consultation consultation : Consultation_info){
            data[index][0] = consultation.getPatient();
            data[index][1] = consultation.getDoctor();
            data[index][2] = consultation.getDate();
            data[index][3] = consultation.getStart_time();
            data[index][4] = consultation.getEnd_time();
            data[index][5] = consultation.getNotes();
            data[index][6] = consultation.getCost();
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



