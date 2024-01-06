package org.example;//package Role;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
//    private final String patientId;
    private final String name;
    private final String familyName;
    private final int age;
    private String address;
    private String phoneNumber;
//    private String dateOfBirth;
    private String diagnosis;
    private double BMI;
    private double bodyTemperature;
    private String bloodPressure;
    private double heartRate;
    private double respiratoryRate;
    private String note;

    public Patient(String name, String familyName, int age, String diagnosis) {
        this.familyName = familyName;
//        this.patientId = generateUniqueId();
        this.name = name;
        this.age = age;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.dateOfBirth = String.valueOf(parseDateOfBirth(String.valueOf(dateOfBirth)));
//        this.BMI = bmi;
//        this.bodyTemperature = bodyTemperature;
//        this.bloodPressure = bloodPressure;
//        this.heartRate = heartRate;
//        this.respiratoryRate = respiratoryRate;
        this.diagnosis = diagnosis;
    }
//    private String generateUniqueId() {
//        return UUID.randomUUID().toString();
//    }
//    public String getPatientId() {
//        return patientId;
//    }

    private Date parseDateOfBirth(String dateOfBirth) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date of birth format. Use yyyy-MM-dd.", e);
        }
    }
    public static String formatToMonthDayYear(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        return dateFormat.format(date);
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

//    public String getDateOfBirth() {
//        return formatToMonthDayYear(dateOfBirth);
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBMI() {
        return BMI;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public double getRespiratoryRate() {
        return respiratoryRate;
    }

    public String getNote() {
        return note;
    }

    public void setAddress(String address){
        this.address = address;
    }

//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public void setBMI(double BMI){
        this.BMI = BMI;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = String.valueOf(bloodPressure);
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public void setRespiratoryRate(double respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


