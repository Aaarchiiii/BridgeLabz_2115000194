package D_20_02_25;
import java.io.*;
public class UserInput {
    public static void main(String[] args) {
        String output = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter w = new FileWriter(output)){
            System.out.println("Enter your name:");
            String name = br.readLine();
            System.out.println("Enter your age:");
            String age = br.readLine();
            System.out.println("Enter your favourite programming language:");
            String language = br.readLine();
            w.write("Name: "+name);
            w.write("Age: "+age);
            w.write("Favorite programming language: "+language);
            System.out.println("Data saved");
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
