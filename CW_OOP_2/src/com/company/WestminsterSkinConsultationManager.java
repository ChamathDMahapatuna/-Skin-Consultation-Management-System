package com.company;
import com.sun.jdi.PathSearchingVirtualMachine;
import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class WestminsterSkinConsultationManager implements Serializable,SkinConsultationManager {

    static Scanner s1= new Scanner(System.in);                       //created Scanner object
    static ArrayList<Doctor> Doctor_info = new ArrayList<Doctor>();         //creating array list called Doctor_info
    Doctor Doctor = new Doctor();                                    //creating doctor object
    Person Person = new  Person();                                   //creating person object

    @Override
    public void Add_new_doctor() {
        try {
            boolean flag = true;
            boolean flag2 = true;
            while (flag) {
                System.out.println("Enter the Doctor First name");
                Person.setName(s1.next());
                String Fname = Person.getName();

                System.out.println("Enter the Doctor surname");
                Person.setSurname(s1.next());
                String Surname = Person.getSurname();

                System.out.println("Enter the Specialization (Cosmetic Dermatology/Medical Dermatology/Paediatric Dermatology...etc): ");
                Doctor.setSpecialisation(s1.next());
                String Specialization = Doctor.getSpecialisation();

                System.out.println("Enter the licence number");
                Doctor.setLicence_number(s1.next());
                String licence_number = Doctor.getLicence_number();

                System.out.println("Enter the Date of birth (YYYY-MM-DD)");
                Person.setDate_of_birth(LocalDate.parse(s1.next()));
                LocalDate dob = Person.getDate_of_birth();

                System.out.println("Enter the mobile number");
                Person.setMobile_number(s1.nextInt());
                int mobile_number = Person.getMobile_number();

                Doctor Doctor1 = new Doctor(Fname,licence_number,Surname,Specialization,dob,mobile_number);
                Doctor_info.add(Doctor1);
                if(10>Doctor_info.size()) { //checkin the number of doctors
                    flag2 = true;
                    // while loop for validate input
                    while (flag2) {

                        System.out.println("Do you need to enter another name(yes/no)?");
                        String input = s1.next();
                        input = input.toLowerCase();
                        if (input.equals("no")) {
                            flag = false;
                            flag2 = false;
                        } else if (input.equals("yes")) {
                            flag = true;
                            flag2 = false;
                        } else {
                            System.out.println("Enter valid Input for the preference");
                            flag2 = true;
                        }
                    }
                }else{
                    System.out.println("!!! Unfortunately we have reached the maximum number of allocated doctors !!!");
                    flag = false;
                }
            }
        }catch(Exception e){
            // using Exceptions
            System.out.println("Please enter the valid input !!");
            System.out.println("Moving back to the main Menu...");
        }
    }

    @Override
    public void Delete_a_doctor() {
        System.out.println("Enter the Doctor License number");
        String name = s1.next();
        for (int i = 0; i < Doctor_info.size(); i++) {                                 //Accessing array elements

            if(name.equals(Doctor_info.get(i).getLicence_number()))
            {
                System.out.println("The doctor who has _ "+Doctor_info.get(i).getLicence_number()+ "_ Licenses number is deleted successfully ");
                System.out.println("Details of the removed doctor");
                System.out.println("First name    :"+ Doctor_info.get(i).getName());
                System.out.println("Last name     :"+ Doctor_info.get(i).getSurname());
                System.out.println("Licence number:"+ Doctor_info.get(i).getLicence_number());
                System.out.println("Date of birth :"+ Doctor_info.get(i).getDate_of_birth());
                System.out.println("Mobile Number :"+ Doctor_info.get(i).getMobile_number());
                System.out.println("Specialisation:"+ Doctor_info.get(i).getSpecialisation());
                Doctor_info.remove(i);
            System.out.println(""+Doctor_info.size()+" Are available at the moment ");}


        }
        System.out.println("There is no entry equals to this Licence number please input valid number");
    }
    @Override
    public void Print_doctors() {
        ArrayList<Doctor> Doctor_info_temp1  = Doctor_info;
        Doctor temp;
                for (int i = 0; i < Doctor_info_temp1.size(); i++) {
                    for (int j = i +1  ; j < Doctor_info_temp1.size(); j++) {
                        if ((Doctor_info_temp1.get(j).getSurname()).compareTo(Doctor_info_temp1.get(i).getSurname()) < 0) {

                            temp = Doctor_info_temp1.get(i);
                            Doctor_info_temp1.set(i, Doctor_info_temp1.get(j));
                            Doctor_info_temp1.set(j, temp);
                        }
                    }
                }

        System.out.println("Doctor Details :");
        for (int i = 0; i < Doctor_info.size(); i++) {                                 //Accessing array elements

            System.out.println("First name    :"+  Doctor_info_temp1.get(i).getName());
            System.out.println("Last name     :"+  Doctor_info_temp1.get(i).getSurname());
            System.out.println("Licence number:"+  Doctor_info_temp1.get(i).getLicence_number());
            System.out.println("Date of birth :"+  Doctor_info_temp1.get(i).getDate_of_birth());
            System.out.println("Mobile Number :"+  Doctor_info_temp1.get(i).getMobile_number());
            System.out.println("Specialisation:"+  Doctor_info_temp1.get(i).getSpecialisation());
            System.out.println("");
        }

    }
    @Override
    public void Save_in_file() {
        try {
            FileOutputStream outputStream = new FileOutputStream("Doctor_information");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream .writeObject(Doctor_info);
            objectOutputStream .close();
            outputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            System.out.println(Doctor_info.size()+ " Records saved Successfully to a Text File");
        }


    }
    @Override
    public void Load_datafile() {
        try {
            FileInputStream inputStream = new FileInputStream("Doctor_information");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Doctor_info = (ArrayList) objectInputStream.readObject();

            objectInputStream.close();
            inputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
                for (int i = 0; i < Doctor_info.size(); i++){
                    if(Doctor_info.size() > 10){
                        Doctor_info.remove(Doctor_info.size() - (i+1));
                    }
                }

              System.out.println(Doctor_info.size() +" Records Loaded Successfully From a Text File");

    }


    public static void menu() {
        System.out.println("                                   -----------------------------                                    ");
        System.out.println("  ---------------------------------  SKIN CONSULTATION CENTRE  -------------------------------------");
        System.out.println("  |                                -----------------------------                                    |");
        System.out.println("  |                                                                                                 |");
        System.out.println("  |                      |ADD OR 1  :  Add Doctor                                                   |");
        System.out.println("  |                      |DEL OR 2  :  Delete Doctor                                                |");
        System.out.println("  |                      |PRI OR 3  :  PRINT Doctor Details                                         |");
        System.out.println("  |                      |SAV OR 4  :  Save Doctor Details                                          |");
        System.out.println("  |                      |LOA OR 5  :  Load Doctor information                                      |");
        System.out.println("  |                      |GUI OR 6  :  Open the GUI                                                 |");
        System.out.println("  |                      |EXIT OR 7 :  Exit                                                         |");
        System.out.println("  |                                                                                                 |");
        System.out.println("  --------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void main(String[] args) throws FileNotFoundException {

        WestminsterSkinConsultationManager lol = new WestminsterSkinConsultationManager();
        boolean Run = true;
        menu();
        while (Run) {

            System.out.println(" ");
            System.out.println("Please Enter an option : ");
            String userInput = s1.next().toUpperCase();
            System.out.println(" ");
            if (userInput.equals("ADD") || userInput.equals("1")) {
                lol.Add_new_doctor();
                menu();
            } else if (userInput.equals("DEL") || userInput.equals("2")) {
                lol.Delete_a_doctor();
                menu();
            } else if (userInput.equals("PRI") || userInput.equals("3")) {
                lol.Print_doctors();
                menu();
            } else if (userInput.equals("SAV") || userInput.equals("4")) {
                lol.Save_in_file();
                menu();
            } else if (userInput.equals("LOA") || userInput.equals("5")) {
                lol.Load_datafile();
                menu();
            } else if (userInput.equals("EXIT") || userInput.equals("7")) {
                System.out.println("Good Bye !!! Come again");
                Run = false;
            } else if (userInput.equals("GUI") || userInput.equals("6")) {
                GUI guii = new GUI();
            } else {
                System.out.println("Please Enter the valid No");
            }

        }
    }
}
