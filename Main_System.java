package org.example;//package Role;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Main_System {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a role:");
        System.out.println("1. Receptionist");
        System.out.println("2. Doctor");
        int choice = scanner.nextInt();
        if (choice == 1) {
            // Receptionist
            DataStorage dataStorage = new DataStorage();
            Receptionist receptionist = new Receptionist(dataStorage);
            do {
                receptionist.registerPatient();
                System.out.println("Do you want to add another patient? (1 for Yes, 0 for No): ");
            } while (scanner.nextInt() == 1);

            System.out.println("\nPatient Database:");
            List<Patient> patientDatabase = dataStorage.getPatients();
            CSVWriter.writePatientToCSVs(patientDatabase, "Patient_DataBase.csv",
                    "WaitingMedInterne.csv", "WaitingSurgery.csv",
                    "WaitingObstetrics.csv");
        } else if (choice == 2) {
            // Doctor
            String specialization = promptForDoctorSpecialization();
            Doctor doctor = new Doctor(specialization);

            // Choose the appropriate data storage based on the doctor's specialization
            DataStorage doctorDataStorage = new DataStorage();
            switch (specialization) {
                case "Surgery":

                    doctor.addDiagnosisFromCSV("WaitingSurgery.csv", doctorDataStorage);
                    doctor.addDiagnosis(doctorDataStorage);
                    ClearCsvFile.clearCsvFile("WaitingSurgery.csv");
                    break;
                case "Internal Medicine":

                    doctor.addDiagnosisFromCSV("WaitingMedInterne.csv", doctorDataStorage);
                    doctor.addDiagnosis(doctorDataStorage);
                    ClearCsvFile.clearCsvFile("WaitingMedInterne.csv");
                    break;
                case "Obstetrics":
                    doctor.addDiagnosisFromCSV("WaitingObstetrics.csv", doctorDataStorage);
                    doctor.addDiagnosis(doctorDataStorage);
                    ClearCsvFile.clearCsvFile("WaitingObstetrics.csv");
                    break;
                default:
                    System.out.println("Invalid specialization. Exiting...");
                    return;
            }
            List<Patient> patientDatabase = doctorDataStorage.getPatients();

            DiagnosisUpdater.writePatientToCSVs(patientDatabase, "DiagnosedMedIn.csv",
                    "DiagnosedSurgery.csv", "DiagnosedObstetrics.csv");

        } else {
            System.out.println("Invalid choice. Exiting...");
        }
    }

    private static String promptForDoctorSpecialization() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose doctor specialization:");
        System.out.println("1. Surgery");
        System.out.println("2. Internal Medicine");
        System.out.println("3. Obstetrics");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Surgery";
            case 2:
                return "Internal Medicine";
            case 3:
                return "Obstetrics";
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
                return "";
        }

    }
}
