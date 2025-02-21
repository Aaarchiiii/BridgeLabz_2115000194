package D_20_02_25;
import java.io.*;
public class ReadWriteFile {
    public static void main(String[] args) {
        String source = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        String destination = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\write.txt";
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = fis.read(buffer))!=-1){
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
