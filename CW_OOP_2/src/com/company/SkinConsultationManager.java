package com.company;

import java.io.FileNotFoundException;
import java.io.Serializable;

public interface SkinConsultationManager extends Serializable {
    public void Add_new_doctor();
    public void Delete_a_doctor();
    public void Print_doctors();
    public void Save_in_file();
    public void Load_datafile() throws FileNotFoundException;

}
