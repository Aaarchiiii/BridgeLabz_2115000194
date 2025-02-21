package D_20_02_25;
import java.io.*;
public class EfficientFileCopy {
    public static void main(String[] args) {
        String source = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        String destination = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\write.txt";
        long start = System.nanoTime();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))){
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = bis.read(buffer))!=-1){
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered streams: File copied");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("Buffered Stream Time: "+(end-start)/1000000);
        start = System.nanoTime();
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)){
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = fis.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered streams: File copied");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        end = System.nanoTime();
        System.out.println("Unbuffered stream time: "+(end-start)/1000000);
    }
}
