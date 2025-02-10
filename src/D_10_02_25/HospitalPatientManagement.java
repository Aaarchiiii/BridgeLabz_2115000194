package D_10_02_25;
import java.util.*;
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public String getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int numberOfDays;
    private ArrayList<String> medicalHistory;
    public InPatient(String patientId, String name, int age, double dailyRate, int numberOfDays) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.numberOfDays = numberOfDays;
        this.medicalHistory = new ArrayList<>();
    }
    public double calculateBill() {
        return dailyRate * numberOfDays;
    }
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + medicalHistory);
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> medicalHistory;
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }
    public double calculateBill() {
        return consultationFee;
    }
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + medicalHistory);
    }
}
public class HospitalPatientManagement {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        InPatient patient1 = new InPatient("P001", "Archi", 45, 500.0, 5);
        OutPatient patient2 = new OutPatient("P002", "Mayank", 30, 100.0);
        patients.add(patient1);
        patients.add(patient2);
        patient1.addRecord("Diagnosed with Pneumonia.");
        patient2.addRecord("Routine check-up.");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                medicalRecord.viewRecords();
            }
        }
    }
}
