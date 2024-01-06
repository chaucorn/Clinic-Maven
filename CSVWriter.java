package org.example;//package Role;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class CSVWriter {

    public static void writePatientToCSVs(List<Patient> patients, String filePath, String filePathMedIn,
                                          String filePathChirurgie, String filePathObstetrique) {
        if (patients.isEmpty()) {
            return;
        }

        try (FileWriter writerAll = new FileWriter(filePath, true);
             FileWriter writerMedIn = new FileWriter(filePathMedIn, true);
             FileWriter writerChirurgie = new FileWriter(filePathChirurgie, true);
             FileWriter writerObstetrique = new FileWriter(filePathObstetrique, true)) {

            for (Patient patient : patients) {
                String patientData = String.format("%s,%s,%s,%s,%s,%s\n",
                        patient.getName(), patient.getFamilyName(), patient.getAge(),
                        patient.getAddress(), patient.getPhoneNumber(), patient.getDiagnosis());

                writerAll.append(patientData);

                // Check the diagnosis type and write to the corresponding file
                switch (patient.getDiagnosis()) {
                    case "Medicine  Interne":
                        writerMedIn.append(patientData);
                        break;
                    case "Chirurgie":
                        writerChirurgie.append(patientData);
                        break;
                    case "Obstetrique":
                        writerObstetrique.append(patientData);
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