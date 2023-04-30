package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    //private JButton names initializing;
    private JButton docInfo;
    private JButton AddConsult;
    private JButton ViewConsult;
    private JButton Patient;
    private JLabel background;
    public GUI() {

        setTitle("Skin Consultation");
        setSize(1000, 830);
        setLayout (null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color. lightGray);
        setLayout(new BorderLayout());

        //construct components
        docInfo = new JButton ("Show doctor Information");
        AddConsult = new JButton ("Add Consultation");
        ViewConsult = new JButton ("View Consultation Details");
        Patient = new JButton ("Patient Information");
        background =new JLabel(new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\CHAMATH\\CW_OOP_2\\com\\company\\lol123.jpg"));

        //adjust size and set layout
        setPreferredSize (new Dimension(800, 400));

        //add components
        add (docInfo);
        add (AddConsult);
        add (ViewConsult);
        add (Patient);
        add (background);

        //Measuring the size
        AddConsult.setBounds (65, 730, 190, 35);
        ViewConsult.setBounds (730, 730, 190, 35);
        docInfo.setBounds (285, 730, 190, 35);
        Patient.setBounds (510, 730, 190, 35);
        background.setLayout(new FlowLayout());
        background.setSize(1000,820);

        docInfo.setBackground(Color.decode("#74c0e5"));
        AddConsult.setBackground(Color.decode("#1889c7"));
        ViewConsult.setBackground(Color.decode("#74c0e5"));
        Patient.setBackground(Color.decode("#1889c7"));

        AddConsult.setBorder(BorderFactory.createLineBorder(Color.white));
        docInfo.setBorder(BorderFactory.createLineBorder(Color.white));
        ViewConsult.setBorder(BorderFactory.createLineBorder(Color.white));
        Patient.setBorder(BorderFactory.createLineBorder(Color.white));

        ActionHandler actHand = new ActionHandler();
        docInfo.addActionListener(actHand);
        AddConsult.addActionListener(actHand);
        ViewConsult.addActionListener(actHand);
        Patient.addActionListener(actHand);

    }

    private class ActionHandler implements ActionListener {

        @Override //action Performed method implementation
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == docInfo){
                Doctor_Info_GUI docInfoGUI = new Doctor_Info_GUI();
                dispose();
            }
            if (e.getSource() ==  AddConsult ){
                Check_Doc Check_Doc = new Check_Doc();
                dispose();
            }
            if (e.getSource() == ViewConsult ){
                Consultation_Details_GUI Consultation_Details_GUI = new Consultation_Details_GUI();
                dispose();
            }
            if (e.getSource() ==  Patient ){
                Patient_details Patient_details = new Patient_details();
                dispose();
            }
        }
    }
}
