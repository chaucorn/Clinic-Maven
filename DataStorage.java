package org.example;//package Role;
import java.util.ArrayList;
import java.util.List;
public class DataStorage {
    private final List<Patient> patients;
    public DataStorage(){
        this.patients = new ArrayList<>();
    }
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public List<Patient> getPatients(){
        return patients;
    }
}
