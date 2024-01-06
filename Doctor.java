package org.example;//package Role;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
//

public class Doctor {
    private final String specialization;

    public Doctor(String specialization) {
        this.specialization = specialization;
    }

    public void addDiagnosisFromCSV(String csvFilePath, DataStorage dataStorage) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> lines = reader.readAll();

            for (String[] line : lines) {
                String name = line[0];
                String familyName = line[1];
                int age = Integer.parseInt(line[2]);
                //String dateOfBirth = line[3];

                Patient patient = new Patient(name, familyName, age);

                dataStorage.addPatient(patient);

                System.out.println("Diagnosis added for patient: " + patient.getName());
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
    public void addDiagnosis(DataStorage dataStorage) {
        List<Patient> patients = dataStorage.getPatients();
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Doctor specializing in " + specialization);
        System.out.println("Patient Database:");

        for (Patient patient : patients) {
            if (patient.getDiagnosis() == null) {
//                System.out.println("Patient ID: " + patient.getPatientId());
                System.out.println("Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
//                System.out.println("Address: " + patient.getAddress());
//                System.out.println("Phone Number: " + patient.getPhoneNumber());
//                System.out.println("Date of Birth: " + DateUtils.formatToMonthDayYear(patient.getDateOfBirth()));
                System.out.println("Diagnosis: " + patient.getDiagnosis());
                System.out.println("-------------------------");

                // Ask the doctor for diagnosis information
                System.out.print("Enter diagnosis for this patient: ");
                System.out.print("BMI:");
                double BMI = scanner.nextDouble();
                patient.setBMI(BMI);
                System.out.print(("Body Temperature:"));
                double bodyTemperature = scanner.nextDouble();
                patient.setBodyTemperature(bodyTemperature);
                System.out.print(("Blood Pressure:"));
                scanner.nextLine();
                String bloodPressure = scanner.nextLine();
                patient.setBloodPressure(bloodPressure);
                System.out.print(("Heart Rate:"));
                double heartRate = scanner.nextDouble();
                patient.setBodyTemperature(heartRate);
                System.out.print(("Respiratory Rate"));
                double respiratoryRate = scanner.nextDouble();
                patient.setBodyTemperature(respiratoryRate);

                
                System.out.println("Diagnosis added successfully.\n");
            }
        }

        System.out.println("No more patients with pending diagnosis for " + specialization);
    }
}
