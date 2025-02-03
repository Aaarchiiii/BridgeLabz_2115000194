package D_04_02_25;

public class Patient {
    static String hospitalName = "Synergy";
    private String name;
    final private int patientId;
    private int age;
    private String ailment;
    static int count = 0;
    public Patient(String name, int patientId, int age, String ailment){
        this.name = name;
        this.patientId = patientId;
        this.age = age;
        this.ailment = ailment;
        count++;
    }
    static void getTotalPatients(){
        System.out.println("Total number of patients: "+count);
    }
    public void Display(){
        System.out.println("Name: "+name);
        System.out.println("Patient Id: "+patientId);
        System.out.println("Age: "+age);
        System.out.println("Ailment: "+ailment);
    }
    public static void main(String[] args) {
        Patient p1 = new Patient("Ram", 105, 40, "Fever");
        System.out.println(p1 instanceof Patient);
        p1.getTotalPatients();
        p1.Display();
    }
}
