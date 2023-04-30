package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Doctor_Info_GUI extends JFrame implements ActionListener {

       static JButton component1;
       static JLabel lbl;
       static ArrayList<Doctor> d1 = WestminsterSkinConsultationManager.Doctor_info;
       JTable doctorTable;
        Doctor_Info_GUI() {
            prepareGUI();
    }

    public void prepareGUI() {
        this.setTitle("View Doctor Details");
        Color ivory = new Color(255, 255, 208);
        this.setVisible(true);
        this.setSize(1500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.decode("#74c0e5"));
        String[] tableColumns = {"Name", "SurName", "DOB", "Mobile No", "M.L. No", "Specialisation"};
        Object[][] data = new Object[d1.size()][6];

        int index = 0;
        for (Doctor doctor : d1) {
            data[index][0] = doctor.getName();
            data[index][1] = doctor.getSurname();
            data[index][2] = doctor.getDate_of_birth();
            data[index][3] = doctor.getMobile_number();
            data[index][4] = doctor.getLicence_number();
            data[index][5] = doctor.getSpecialisation();
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







