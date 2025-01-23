package D_23_01_25.Level1;
import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int date = sc.nextInt();
        if(month==3 && date>=20 && date<=31){
            System.out.println("It's a spring season");
        }
        else if(month==4 && date>=1 && date<=30){
            System.out.println("It's a spring season");
        }
        else if(month==5 && date>=1 && date<=31){
            System.out.println("It's a spring season");
        }
        if(month==6 && date>=1 && date<=20){
            System.out.println("It's a spring season");
        }
        else{
            System.out.println("Not a spring season");
        }
    }
}
