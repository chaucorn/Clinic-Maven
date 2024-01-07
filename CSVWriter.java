package org.example;//package Role;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class CSVWriter {

    public static void writePatientToCSVs(List<Patient> patients, String filePath,
                                          String filePathMedIn, String filePathSurgery,
                                          String filePathObstetrics) {
        if (patients.isEmpty()) {
            return;
        }

        try (FileWriter writerAll = new FileWriter(filePath, true);
             FileWriter writerMedIn = new FileWriter(filePathMedIn, true);
             FileWriter writerSurgery = new FileWriter(filePathSurgery, true);
             FileWriter writerObstetrics = new FileWriter(filePathObstetrics, true)) {

            for (Patient patient : patients) {
                String patientData = String.format("%s,%s,%s,%s,%s,%s\n",
                        patient.getName(), patient.getFamilyName(), patient.getAge(),
                        patient.getAddress(), patient.getPhoneNumber(), patient.getDiagnosis());

                writerAll.append(patientData);

                // Check the diagnosis type and write to the corresponding file
                switch (patient.getDiagnosis()) {
                    case "Internal Medicine":
                        writerMedIn.append(patientData);
                        break;
                    case "Surgery":
                        writerSurgery.append(patientData);
                        break;
                    case "Obstetrics":
                        writerObstetrics.append(patientData);
                        break;
                    default:
                        break;
                }
            }

            System.out.println("Data written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}