package D_06_02_25;

import java.util.*;
class Doctor {
    String doctorName;
    ArrayList<Patient> patients;
    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        patients = new ArrayList<>();
    }
    public void consult(Patient patient) {
        System.out.println("Doctor " + doctorName + " is consulting with Patient " + patient.patientName);
        patients.add(patient);
        patient.addConsultation(this);
    }
    public void showConsultations() {
        System.out.println("Doctor " + doctorName + " has consulted with the following patients:");
        for (Patient patient : patients) {
            System.out.println("  Patient: " + patient.patientName);
        }
    }
}
class Patient {
    String patientName;
    ArrayList<Doctor> doctors;
    public Patient(String patientName) {
        this.patientName = patientName;
        doctors = new ArrayList<>();
    }
    public void addConsultation(Doctor doctor) {
        doctors.add(doctor);
    }
    public void showDoctors() {
        System.out.println("Patient " + patientName + " has consulted the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  Doctor: " + doctor.doctorName);
        }
    }
}
class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void showHospitalDetails() {
        System.out.println("Hospital: " + hospitalName);
        for (Doctor doctor : doctors) {
            doctor.showConsultations();
        }
        for (Patient patient : patients) {
            patient.showDoctors();
        }
    }
}
public class HospitalDetails {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Synergy Plus Hospital");
        Doctor doctor1 = new Doctor("Dr. Sunil");
        Doctor doctor2 = new Doctor("Dr. Shaily");
        Patient patient1 = new Patient("Mayank");
        Patient patient2 = new Patient("Archi");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        doctor1.consult(patient1);
        doctor2.consult(patient1);
        doctor1.consult(patient2);
        hospital.showHospitalDetails();
    }
}
