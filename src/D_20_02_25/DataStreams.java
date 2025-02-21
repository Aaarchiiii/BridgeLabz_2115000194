package D_20_02_25;

import java.io.*;
public class DataStreams {
    public static void main(String[] args) {
        String file = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Archi");
            dos.writeDouble(3.8);
            System.out.println("Student details written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Retrieved Student Details:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
