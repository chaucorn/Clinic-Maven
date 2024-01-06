package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class DiagnosisUpdater {

    public static void writePatientToCSVs(List<Patient> patients, String filePathMedIn,
                                          String filePathChirurgie, String filePathObstetrique) throws IOException {
        if (patients.isEmpty()) {
            return;
        }


        try (FileWriter updateMedIn = new FileWriter(filePathMedIn, true);
             FileWriter updateChirurgie = new FileWriter(filePathChirurgie, true);
             FileWriter updateObstetrique = new FileWriter(filePathObstetrique, true)) {

            for (Patient patient : patients) {
                String patientData = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        patient.getName(), patient.getFamilyName(), patient.getAge(),
                        patient.getAddress(), patient.getPhoneNumber(),
                        patient.getDiagnosis(), patient.getBMI(),
                        patient.getBodyTemperature(), patient.getBloodPressure(),
                        patient.getHeartRate(), patient.getRespiratoryRate(), patient.getNote());

                // Check the diagnosis type and write to the corresponding file
                switch (patient.getDiagnosis()) {
                    case "Medicine  Interne":
                        updateMedIn.append(patientData);
                        break;
                    case "Chirurgie":
                        updateChirurgie.append(patientData);
                        break;
                    case "Obstetrique":
                        updateObstetrique.append(patientData);
                        break;
                    // Add more cases for other diagnosis types if needed
                    default:
                        // Handle unknown diagnosis type or ignore
                        break;
                }
            }

            System.out.println("Data written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
